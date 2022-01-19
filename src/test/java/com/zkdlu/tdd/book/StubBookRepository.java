package com.zkdlu.tdd.book;

import com.zkdlu.tdd.book.Book;
import com.zkdlu.tdd.book.BookRepository;
import com.zkdlu.tdd.book.NewBook;

import java.util.List;

public class StubBookRepository implements BookRepository {
    public List<Book> getAll_returnValue;
    public Book get_returnValue;
    public NotFoundException getById_throwsException;

    @Override
    public List<Book> getAll() {
        return getAll_returnValue;
    }

    @Override
    public Book getById(long id) {
        if (getById_throwsException != null) {
            throw getById_throwsException;
        }

        return get_returnValue;
    }

    @Override
    public Book create(NewBook newBook) {
        return null;
    }
}
