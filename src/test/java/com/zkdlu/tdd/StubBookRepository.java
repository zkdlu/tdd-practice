package com.zkdlu.tdd;

import java.util.List;

public class StubBookRepository implements BookRepository {
    public List<Book> getAll_returnValue;
    public Book get_returnValue;

    @Override
    public List<Book> getAll() {
        return getAll_returnValue;
    }

    @Override
    public Book get() {
        return get_returnValue;
    }
}