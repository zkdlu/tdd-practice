package com.zkdlu.tdd.book;

import lombok.Getter;

@Getter
public class ResourceError {
    private String errorMessage;

    public ResourceError(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
