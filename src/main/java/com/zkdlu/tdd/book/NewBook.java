package com.zkdlu.tdd.book;

import lombok.Getter;

@Getter
public class NewBook {
    private final String name;
    private final String author;

    public NewBook(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
