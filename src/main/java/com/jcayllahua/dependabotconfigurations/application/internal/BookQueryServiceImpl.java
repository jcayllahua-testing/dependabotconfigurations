package com.jcayllahua.dependabotconfigurations.application.internal;

import com.jcayllahua.dependabotconfigurations.domain.Book;
import com.jcayllahua.dependabotconfigurations.domain.services.BookQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class BookQueryServiceImpl implements BookQueryService {
    @Override
    public Mono<List<Book>> getBooks(String titleFilter) {
       return Mono.fromCallable(() -> {
           log.info("Getting books for titleFilter={}", titleFilter);
           return List.of(
                   new Book("Book 1", "Fiction"),
                   new Book("Book 2", "Non-Fiction"),
                   new Book("Book 3", "Science Fiction")
           );
       });
    }
}
