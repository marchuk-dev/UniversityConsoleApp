package com.uni.universityconsoleapp.exceptions;

import com.uni.universityconsoleapp.entities.Department;

public class LectorNotFoundException extends RuntimeException {
    private static final String MESSAGE_BY_NAME = "Lector not found by %s name";
    private static final String MESSAGE_BY_DEPARTMENT = "Lector not found by %s department name";

    public LectorNotFoundException(String lectorName) {
        super(String.format(MESSAGE_BY_NAME, lectorName));
    }

    public LectorNotFoundException(Department department) {
        super(String.format(MESSAGE_BY_DEPARTMENT, department.getName()));
    }

}
