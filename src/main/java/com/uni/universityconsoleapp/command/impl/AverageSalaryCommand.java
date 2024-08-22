package com.uni.universityconsoleapp.command.impl;

import com.uni.universityconsoleapp.command.AbstractCommand;
import com.uni.universityconsoleapp.services.impl.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class AverageSalaryCommand extends AbstractCommand {

    private static final String REQUEST_MESSAGE = "Show the average salary for the department";
    private static final String RESPONSE_MESSAGE = "Answer: The average salary of %s is %s";

    private final DepartmentService departmentService;

    @Override
    public void execute(String input) {
        String requestValue = getFormattedRequest(input);
        BigDecimal averageSalary = departmentService.getAverageSalaryByDepartmentName(requestValue);
        System.out.printf((RESPONSE_MESSAGE) + "%n", requestValue, averageSalary);
    }

    @Override
    public String getRequestMessage() {
        return REQUEST_MESSAGE;
    }
}
