package com.zkdlu.tdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookApi {
    @GetMapping
    public List<String> getBooks() {
        return new ArrayList<>();
    }
}
