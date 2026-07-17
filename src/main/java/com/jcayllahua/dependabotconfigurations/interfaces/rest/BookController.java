package com.jcayllahua.dependabotconfigurations.interfaces.rest;

import com.jcayllahua.dependabotconfigurations.domain.Book;
import com.jcayllahua.dependabotconfigurations.domain.services.BookQueryService;
import com.jcayllahua.dependabotconfigurations.utils.LogSanitizer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/books")
@Slf4j
@RequiredArgsConstructor
public class BookController {

    private final BookQueryService bookQueryService;

    @Operation(summary = "Get all books", description = "Returns a list of all books")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of books")
    @GetMapping(produces = "application/json")
    public Mono<ResponseEntity<List<Book>>> getBooks(
            @Parameter(description = "Optional query parameter to filter books by title", required = false)
            String titleFilter
    ) {
        log.info("The value of titleFilter: {}", LogSanitizer.sanitize(titleFilter));
        return bookQueryService.getBooks(titleFilter)
                .doOnNext(books -> log.info("Retrieved {} books for titleFilter={}", books.size(), LogSanitizer.sanitize(titleFilter)))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
