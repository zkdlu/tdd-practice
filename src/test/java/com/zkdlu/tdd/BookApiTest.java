package com.zkdlu.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BookApiTest {
    private MockMvc mockMvc;
    private StubBookRepository stubBookRepository;

    @BeforeEach
    void setUp() {
        stubBookRepository = new StubBookRepository();
        BookApi bookApi = new BookApi(stubBookRepository);

        mockMvc = MockMvcBuilders
                .standaloneSetup(bookApi)
                .build();
    }

    @Test
    void test_getBookApi_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk());
    }

    @Test
    void test_getBookApi_returnsASingleBook() throws Exception {
        stubBookRepository.getAll_returnValue = Collections.singletonList(
                new Book("book name", "book author"));

        mockMvc.perform(get("/api/books"))
                .andExpect(jsonPath("$[0].name", equalTo("book name")))
                .andExpect(jsonPath("$[0].author", equalTo("book author")));
    }
}