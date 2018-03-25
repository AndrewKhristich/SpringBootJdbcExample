package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class MyResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex) {
        System.out.println("Exception Handler");
        return createErrorResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LineNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleTopNotFoundException(LineNotFoundException ex) {
        System.out.println("TopNotFound Handler");
        return createErrorResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("MethodValid Handler");
        return createObjectErrorResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ExceptionResponse> createErrorResponseEntity(Exception ex, HttpStatus httpStatus) {
        return new ResponseEntity<>(new ExceptionResponse(new Date(), ex.getMessage()), httpStatus);
    }

    private ResponseEntity<Object> createObjectErrorResponseEntity(Exception ex, HttpStatus httpStatus) {
        return new ResponseEntity<>(new ExceptionResponse(new Date(), ex.getMessage()), httpStatus);
    }
}
