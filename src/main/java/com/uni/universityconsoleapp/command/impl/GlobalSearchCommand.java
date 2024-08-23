package com.uni.universityconsoleapp.command.impl;

import com.uni.universityconsoleapp.command.AbstractCommand;
import com.uni.universityconsoleapp.entities.Department;
import com.uni.universityconsoleapp.entities.Lector;
import com.uni.universityconsoleapp.services.DepartmentService;
import com.uni.universityconsoleapp.services.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GlobalSearchCommand extends AbstractCommand {

    private static final String REQUEST_MESSAGE = "Global search by";
    private static final String RESPONSE_MESSAGE = "Answer: Global search by %s: %s";

    private final LectorService lectorService;
    private final DepartmentService departmentService;

    @Override
    public void execute(String input) {
        String requestValue = getFormattedRequest(input);

        List<String> lectorResults = lectorService.findByNameContaining(requestValue)
                .stream()
                .map(Lector::getName)
                .toList();

        List<String> departmentResults = departmentService.findByNameContaining(requestValue)
                .stream()
                .map(Department::getName)
                .toList();

        String result = formatResults(lectorResults, departmentResults);

        System.out.println(result);
    }

    @Override
    public String getRequestMessage() {
        return REQUEST_MESSAGE;
    }

    private String formatResults(List<String> lectorResults, List<String> departmentResults) {
        return String.format(RESPONSE_MESSAGE, "Lectors", String.join(", ", lectorResults)) + "\n" +
                String.format(RESPONSE_MESSAGE, "Departments", String.join(", ", departmentResults));
    }

}
