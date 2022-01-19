package com.zkdlu.tdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookApi {
    @GetMapping
    public List<Book> getBooks() {
        Book tddBook = new Book("TDD by Example", "Kent Beck");

        return Collections.singletonList(tddBook);
    }
}
