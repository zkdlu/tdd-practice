package com.zkdlu.tdd;

import java.util.List;

public class SpyBookRepository implements BookRepository {
    public long get_argument_id;

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public Book get(long id) {
        get_argument_id = id;
        return null;
    }
}
