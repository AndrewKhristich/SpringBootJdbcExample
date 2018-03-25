package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class LineModel {
    private Long id;

    @NotNull
    @Size(min = 1)
    private String name;

    public LineModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
