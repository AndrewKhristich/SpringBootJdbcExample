package com.example.demo.repository;

import com.example.demo.model.LineModel;

import java.util.List;

public interface DataBaseRepository {
    void addOneLineByName(String name);
    List<LineModel> findAll();
    String findById(Long id);
    List<LineModel> findAllByName(String name);
}
