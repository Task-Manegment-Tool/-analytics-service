package com.blue.analytics_service.exception_handler_controllers;
import com.blue.analytics_service.exceptions.UserIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserPerformanceExceptionHandlerController {
    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<String> handleUserIdNotFoundException(UserIdNotFoundException userIdNotFoundException) {
        return new ResponseEntity<>(userIdNotFoundException.getMessage(), HttpStatus.OK);
    }
}
