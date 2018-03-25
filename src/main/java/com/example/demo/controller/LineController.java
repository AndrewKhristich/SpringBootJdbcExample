package com.example.demo.controller;

import com.example.demo.model.LineModel;
import com.example.demo.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LineController {

    private LineService service;

    @Autowired
    public LineController(LineService service) {
        this.service = service;
    }

    public LineController() {

    }

    @GetMapping("/list")
    public List<LineModel> findAllLines() {
        return service.findAllLines();
    }

    @PostMapping("/list")
    public String addLine(@Valid @RequestBody String name) {
        service.addLine(name);
        return "POST IS DONE";
    }

    @GetMapping("/findId/{id}")
    public String findOneById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/findName/{name}")
    public List<LineModel> findAllByName(@Valid @PathVariable String name) {
        return service.findAllByName(name);
    }

}
