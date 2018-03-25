package com.example.demo;

import com.example.demo.controller.LineController;
import com.example.demo.model.LineModel;
import com.example.demo.repository.Impl.DataBaseRepositoryImpl;
import com.example.demo.service.Impl.LineServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(LineController.class)
public class LineControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LineController controller;

    @MockBean
    private DataBaseRepositoryImpl repository;
    @MockBean
    private JdbcTemplate jdbcTemplate;
    @MockBean
    private LineServiceImpl service;

    public LineControllerTest() {
    }

    @Test
    public void testFindById() throws Exception {
    }

    @Test
    public void testAddLine() throws Exception {
        String randomLine = "randomLine";

        given(controller.addLine(randomLine)).willReturn("POST IS DONE");

        String response = mvc.perform(post("/list").content(randomLine))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();

        assertThat(response).isEqualTo("POST IS DONE");
        verify(controller).addLine(randomLine);
    }

    @Test
    public void tesFindALLLines() throws Exception {
        List<LineModel> list = Arrays.asList(
                new LineModel(1l,"asd"),
                new LineModel(2l,"asd1"),
                new LineModel(3l, "asd2"),
                new LineModel(4l, "asd")
        );

        given(controller.findAllLines()).willReturn(list);

        mvc.perform(get("/list")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("asd")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("asd1")))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].name", is("asd2")))
                .andExpect(jsonPath("$[3].id", is(4)))
                .andExpect(jsonPath("$[3].name", is("asd")));

        verify(controller).findAllLines();
    }

    @Test
    public void testFindAllByNames() throws Exception {

    }
}
