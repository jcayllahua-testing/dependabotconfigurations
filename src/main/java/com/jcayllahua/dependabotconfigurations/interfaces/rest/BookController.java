package com.jcayllahua.dependabotconfigurations.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
public class BookController {

    @Operation(summary = "Get all books", description = "Returns a list of all books")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of books")
    @GetMapping(produces = "application/json")
    public Mono<ResponseEntity<List<String>>> getBooks(
            @Parameter(description = "Optional query parameter to filter books by title", required = false)
            String titleFilter
    ) {
        log.info("titleFilter: {}", titleFilter);
        List<String> books = List.of("Book 1", "Book 2", "Book 3");
        return Mono.just(ResponseEntity.ok(books));
    }
}
