package com.zkdlu.tdd;

import lombok.Getter;

@Getter
public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }
}
