package com.zkdlu.tdd;

import java.util.List;

public interface BookRepository {
    List<Book> getAll();

    Book getById(long id);

    Book create(NewBook newBook);
}
