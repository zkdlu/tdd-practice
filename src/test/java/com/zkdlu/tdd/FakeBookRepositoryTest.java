package com.zkdlu.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FakeBookRepositoryTest {

    private FakeBookRepository fakeBookRepository;

    @BeforeEach
    void setUp() {
        fakeBookRepository = new FakeBookRepository();
    }

    @Test
    void fakeBookRepository_whenNoBookHaveBeenSaved_hasNoBooks() {
        assertThat(fakeBookRepository.getAll().size()).isEqualTo(0);
    }

    @Test
    void fakeBookRepository_whenBookHaveBeenSaved_returnsAllBooks() {
        fakeBookRepository.create(new NewBook("book name 1", "book author 1"));
        fakeBookRepository.create(new NewBook("book name 2", "book author 2"));

        List<Book> allBooks = fakeBookRepository.getAll();

        assertThat(allBooks.get(0)).isEqualTo(new Book(1L, "book name 1", "book author 1"));
        assertThat(allBooks.get(1)).isEqualTo(new Book(2L, "book name 2", "book author 2"));
    }

    @Test
    void fakeBookRepository_whenBookHaveBeenSaved_returnsBookById() {
        fakeBookRepository.create(new NewBook("book name 1", "book author 1"));
        fakeBookRepository.create(new NewBook("book name 2", "book author 2"));

        Book actualBook = fakeBookRepository.getById(2);

        assertThat(actualBook).isEqualTo(new Book(2L, "book name 2", "book author 2"));
    }
}