package com.blue.analytics_service.exceptions;

public class ProjectIdNotFoundException extends RuntimeException {
    public ProjectIdNotFoundException(String message) {
        super(message);
    }
}
