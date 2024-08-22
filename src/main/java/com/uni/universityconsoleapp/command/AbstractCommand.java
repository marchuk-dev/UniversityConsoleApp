package com.uni.universityconsoleapp.command;

public abstract class AbstractCommand implements Command {

    @Override
    public boolean canExecute(String input) {
        return input.toLowerCase().contains(getRequestMessage().toLowerCase());
    }

    @Override
    public String getFormattedRequest(String input) {
        return input.replace(getRequestMessage(), "").trim();
    }

    @Override
    public void printInstructions() {
        System.out.println("------------------------------");
        System.out.println("Please enter your request, e.g.:");
        System.out.println("Who is head of department {department_name}");
        System.out.println("OR");
        System.out.println("Show {department_name} statistics");
        System.out.println("OR");
        System.out.println("Show the average salary for the department {department_name}");
        System.out.println("OR");
        System.out.println("Show count of employee for {department_name}");
        System.out.println("OR");
        System.out.println("Global search by {template}");
        System.out.println("------------------------------");
    }

}