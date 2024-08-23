package com.uni.universityconsoleapp.command.impl;

import com.uni.universityconsoleapp.command.AbstractCommand;
import com.uni.universityconsoleapp.dto.DepartmentStatistics;
import com.uni.universityconsoleapp.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.uni.universityconsoleapp.entities.Lector.Degree.*;

@Component
@RequiredArgsConstructor
public class DepartmentStatisticsCommand extends AbstractCommand {

    private static final String REQUEST_MESSAGE = "Show statistics";
    private static final String RESPONSE_MESSAGE = "Answer: %s - %d. %s - %d. %s - %d.";

    private final DepartmentService departmentService;

    @Override
    public void execute(String input) {
        String requestValue = getFormattedRequest(input);
        DepartmentStatistics statistics = departmentService.getStatisticsByDepartmentName(requestValue);
        System.out.println(formatResults(statistics));
    }

    @Override
    public String getRequestMessage() {
        return REQUEST_MESSAGE;
    }

    @Override
    public boolean canExecute(String input) {
        String regex = "Show\\s+.*\\s+statistics";
        return input.toLowerCase().matches(regex.toLowerCase());
    }

    @Override
    public String getFormattedRequest(String input) {
        String regex = "Show\\s+(.*?)\\s+statistics";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1).trim();
        } else {
            System.err.println("Input: " + input);
            System.err.println("Regex: " + regex);
            throw new IllegalArgumentException("Invalid input format.");
        }

    }

    private String formatResults(DepartmentStatistics statistics) {
        return String.format(RESPONSE_MESSAGE,
                ASSISTANT.name().toLowerCase(), statistics.getCountForDegree(ASSISTANT),
                ASSOCIATE_PROFESSOR.name().toLowerCase(), statistics.getCountForDegree(ASSOCIATE_PROFESSOR),
                PROFESSOR.name().toLowerCase(), statistics.getCountForDegree(PROFESSOR)
        );
    }

}
