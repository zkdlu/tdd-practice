package com.zkdlu.tdd;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Book {
    private long id;
    private String name;
    private String author;

    public Book(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
