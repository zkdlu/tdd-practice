package com.zkdlu.tdd.book;

import com.zkdlu.tdd.book.Book;
import com.zkdlu.tdd.book.BookRepository;
import com.zkdlu.tdd.book.NewBook;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MockBookRepository implements BookRepository {
    private Long getById_argument_id;

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public Book getById(long id) {
        getById_argument_id = id;
        return null;
    }

    @Override
    public Book create(NewBook newBook) {
        return null;
    }

    public void verify_getById(long id) {
        assertThat(getById_argument_id).isEqualTo(id);
    }
}
