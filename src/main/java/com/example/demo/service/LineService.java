package com.example.demo.service;

import com.example.demo.model.LineModel;

import java.util.List;

public interface LineService {
    List<LineModel> findAllLines();
    void addLine(String name);
    List<LineModel> findAllByName(String name);
    String findById(Long id);
}
