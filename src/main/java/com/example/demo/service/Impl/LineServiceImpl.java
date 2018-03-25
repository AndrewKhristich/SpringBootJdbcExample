package com.example.demo.service.Impl;

import com.example.demo.exception.LineNotFoundException;
import com.example.demo.model.LineModel;
import com.example.demo.repository.DataBaseRepository;
import com.example.demo.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineServiceImpl implements LineService {

    private DataBaseRepository repository;

    @Autowired
    public LineServiceImpl(DataBaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LineModel> findAllLines() {
        List<LineModel> list = repository.findAll();
        if (list == null){
            throw new LineNotFoundException();
        }
        return list;
    }

    @Override
    public void addLine(String name) {
        repository.addOneLineByName(name);
    }

    @Override
    public List<LineModel> findAllByName(String name) {
        List<LineModel> list = repository.findAllByName(name);
        if (list == null){
            throw new LineNotFoundException();
        }
        return list;
    }

    @Override
    public String findById(Long id) {
        String name = repository.findById(id);
        if (name==null){
            throw new LineNotFoundException();
        }
        return name;
    }
}
