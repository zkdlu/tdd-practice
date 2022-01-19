package com.zkdlu.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BookApiTest {
    @Test
    void test_getBookApi_returnsOkHttpStatus() throws Exception {
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(new BookApi())
                .build();

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk());
    }

    @Test
    void test_getBookApi_returnsAnEmptyList() throws Exception {
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(new BookApi())
                .build();

        mockMvc.perform(get("/api/books"))
                .andExpect(jsonPath("$", hasSize(0)));
    }
}