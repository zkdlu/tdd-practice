package com.zkdlu.tdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookApi {
    private final BookRepository bookRepository;

    public BookApi(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.getAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return bookRepository.getById(id);
    }

}
