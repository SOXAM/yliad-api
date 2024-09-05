package com.soxam.yliad.daily;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DailyNotFoundAdvice {
    
    @ExceptionHandler(DailyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String dailyNotFoundHandler(DailyNotFoundException ex) {
        return ex.getMessage();
    }
}
