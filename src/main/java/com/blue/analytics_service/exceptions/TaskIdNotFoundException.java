package com.blue.analytics_service.exceptions;

public class TaskIdNotFoundException extends RuntimeException {
    public TaskIdNotFoundException(String message) {
        super(message);
    }
}
