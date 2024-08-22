package com.uni.universityconsoleapp.command.impl;

import com.uni.universityconsoleapp.command.AbstractCommand;
import com.uni.universityconsoleapp.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeCountCommand extends AbstractCommand {

    private static final String REQUEST_MESSAGE = "Show count of employee for";
    private static final String RESPONSE_MESSAGE = "Answer: %d";

    private final DepartmentService departmentService;

    @Override
    public void execute(String input) {
        String requestValue = getFormattedRequest(input);
        int employeeCount = departmentService.getEmployeeCountByDepartmentName(requestValue);
        System.out.printf((RESPONSE_MESSAGE) + "%n", employeeCount);
        printInstructions();
    }

    @Override
    public String getRequestMessage() {
        return REQUEST_MESSAGE;
    }

}
