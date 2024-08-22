package com.uni.universityconsoleapp.command.impl;

import com.uni.universityconsoleapp.command.AbstractCommand;
import com.uni.universityconsoleapp.entities.Department;
import com.uni.universityconsoleapp.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeadOfDepartmentCommand extends AbstractCommand {

    private static final String REQUEST_MESSAGE = "Who is head of department";
    private static final String RESPONSE_MESSAGE = "Answer: Head of %s department is %s";

    private final DepartmentService departmentService;

    @Override
    public void execute(String input) {
        String requestValue = getFormattedRequest(input);
        Department department = departmentService.getByName(requestValue);
        System.out.printf((RESPONSE_MESSAGE) + "%n", department.getName(), department.getHead());
        printInstructions();
    }

    @Override
    public String getRequestMessage() {
        return REQUEST_MESSAGE;
    }

}
