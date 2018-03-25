package com.example.demo.exception;

import lombok.Data;

import java.util.Date;

@Data
class ExceptionResponse {
    private Date timestamp;

    private String message;


    ExceptionResponse(Date date, String message) {
        this.timestamp = date;
        this.message = message;
    }
}
