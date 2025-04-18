package com.example.demo.validator;

import org.springframework.stereotype.Component;

@Component
public class StudentValidator {
    
    public void validateId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Student ID cannot be null");
        }
    }
    
    public void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
    }
} 