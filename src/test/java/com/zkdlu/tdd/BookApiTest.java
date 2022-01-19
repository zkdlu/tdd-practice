package com.zkdlu.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
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
    void getBooks_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk());
    }

    @Test
    void getBooks_returnsASingleBook() throws Exception {
        stubBookRepository.getAll_returnValue = Collections.singletonList(
                new Book(1L, "book name", "book author"));

        mockMvc.perform(get("/api/books"))
                .andExpect(jsonPath("$[0].name", equalTo("book name")))
                .andExpect(jsonPath("$[0].author", equalTo("book author")));
    }

    @Test
    void getBooks_returnsASingleBook_usingMockito() throws Exception {
        BookRepository mockBookRepository = mock(BookRepository.class);
        BookApi bookApi = new BookApi(mockBookRepository);

        mockMvc = MockMvcBuilders
                .standaloneSetup(bookApi)
                .build();

        when(mockBookRepository.getAll())
                .thenReturn(Collections.singletonList(new Book(1L, "book name", "book author")));

        mockMvc.perform(get("/api/books"))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("book name")))
                .andExpect(jsonPath("$[0].author", equalTo("book author")));
    }

    @Test
    void getBook_returnsOkHttpStatus() throws Exception {
        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getBook_returnsASingleBook() throws Exception {
        stubBookRepository.get_returnValue = new Book(1L, "book name", "book author");

        mockMvc.perform(get("/api/books/1"))
                .andExpect(jsonPath("$.id", equalTo(1)))
                .andExpect(jsonPath("$.name", equalTo("book name")))
                .andExpect(jsonPath("$.author", equalTo("book author")));
    }

    @Test
    void getBook_passesDataToRepository() throws Exception {
        SpyBookRepository spyBookRepository = new SpyBookRepository();
        BookApi bookApi = new BookApi(spyBookRepository);

        mockMvc = MockMvcBuilders
                .standaloneSetup(bookApi)
                .build();

        mockMvc.perform(get("/api/books/10"));

        assertThat(spyBookRepository.get_argument_id).isEqualTo(10L);
    }

    @Test
    void getBook_passesDataToRepository_usingMockito() throws Exception {
        BookRepository mockBookRepository = mock(BookRepository.class);
        BookApi bookApi = new BookApi(mockBookRepository);

        mockMvc = MockMvcBuilders
                .standaloneSetup(bookApi)
                .build();

        mockMvc.perform(get("/api/books/10"));

        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(mockBookRepository, times(1)).getById(longArgumentCaptor.capture());

        assertThat(longArgumentCaptor.getValue()).isEqualTo(10L);
    }

    @Test
    void getBook_passesDataToRepository_usingTrueMock() throws Exception {
        MockBookRepository trueMockBookRepository = new MockBookRepository();
        BookApi bookApi = new BookApi(trueMockBookRepository);

        mockMvc = MockMvcBuilders
                .standaloneSetup(bookApi)
                .build();

        mockMvc.perform(get("/api/books/10"));

        trueMockBookRepository.verify_getById(10L);

    }
}