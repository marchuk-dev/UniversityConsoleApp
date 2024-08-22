package com.uni.universityconsoleapp.exceptions;

public class DepartmentNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Department not found by %s name";

    public DepartmentNotFoundException(String name) {
        super(String.format(MESSAGE, name));
    }
}
