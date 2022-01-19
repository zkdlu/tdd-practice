package com.zkdlu.tdd.book;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}