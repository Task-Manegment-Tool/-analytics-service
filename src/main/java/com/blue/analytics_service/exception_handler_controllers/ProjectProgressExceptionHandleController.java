package com.blue.analytics_service.exception_handler_controllers;

import com.blue.analytics_service.exceptions.ProjectIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectProgressExceptionHandleController {
    public ResponseEntity<String> handleProjectIdNotFoundException(ProjectIdNotFoundException projectIdNotFoundException) {
        return new ResponseEntity<>(projectIdNotFoundException.getMessage(), HttpStatus.OK);
    }
}
