package com.example.demo.service.Impl;

import com.example.demo.model.LineModel;
import com.example.demo.repository.DataBaseRepository;
import com.example.demo.service.LineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LineServiceTest {

    @Autowired
    private LineService service;

    @MockBean
    private DataBaseRepository repository;

    @Test
    public void findAllLines() {
        List<LineModel> list = Arrays.asList(
                new LineModel(1L,"asd"),
                new LineModel(2L,"asd1"),
                new LineModel(3L,"asd3"),
                new LineModel(4L,"asd")
        );

        when(repository.findAll()).thenReturn(list);

        List<LineModel> list1 = service.findAllLines();

        assertEquals(list, list1);
    }

    @Test
    public void addLine() {
        String name = "asd111";
        service.addLine(name);
        verify(repository, times(1)).addOneLineByName(name);
    }

    @Test
    public void findAllByName() {
        List<LineModel> list = Arrays.asList(
                new LineModel(1L,"asd"),
                new LineModel(4L,"asd")
        );
        String name = "asd";

        when(repository.findAllByName(name)).thenReturn(list);

        List<LineModel> list1 = service.findAllByName(name);

        assertEquals(list, list1);
    }

    @Test
    public void findById() {
        Long id = 2L;
        String name = "Andrey";

        when(repository.findById(id)).thenReturn(name);

        String result = service.findById(2L);

        assertEquals(name, result);
    }
}