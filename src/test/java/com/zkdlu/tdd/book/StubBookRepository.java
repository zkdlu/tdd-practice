package com.zkdlu.tdd.book;

import com.zkdlu.tdd.book.Book;
import com.zkdlu.tdd.book.BookRepository;
import com.zkdlu.tdd.book.NewBook;

import java.util.List;

public class StubBookRepository implements BookRepository {
    public List<Book> getAll_returnValue;
    public Book get_returnValue;

    @Override
    public List<Book> getAll() {
        return getAll_returnValue;
    }

    @Override
    public Book getById(long id) {
        return get_returnValue;
    }

    @Override
    public Book create(NewBook newBook) {
        return null;
    }
}
