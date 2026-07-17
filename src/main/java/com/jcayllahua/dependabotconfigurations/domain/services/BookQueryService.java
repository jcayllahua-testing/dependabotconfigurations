package com.jcayllahua.dependabotconfigurations.domain.services;

import com.jcayllahua.dependabotconfigurations.domain.Book;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BookQueryService {
    Mono<List<Book>> getBooks(String titleFilter);
}
