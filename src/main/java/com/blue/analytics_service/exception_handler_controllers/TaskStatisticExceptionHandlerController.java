package com.blue.analytics_service.exception_handler_controllers;

import com.blue.analytics_service.exceptions.TaskIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskStatisticExceptionHandlerController {
    @ExceptionHandler(TaskIdNotFoundException.class)
    public ResponseEntity<String> handelTaskIdNotFoundException(TaskIdNotFoundException taskIdNotFoundException) {
        return new ResponseEntity<>(taskIdNotFoundException.getMessage(), HttpStatus.OK);
    }
}
