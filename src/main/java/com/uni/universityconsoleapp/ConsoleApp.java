package com.uni.universityconsoleapp;

import com.uni.universityconsoleapp.command.dispatcher.CommandDispatcher;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleApp {

    private final CommandDispatcher commandDispatcher;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleApp(CommandDispatcher commandDispatcher) {
        this.commandDispatcher = commandDispatcher;
    }

    public void run() {
        System.out.println("Welcome to the University Console App");
        printInstructions();
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            commandDispatcher.dispatch(input);
        }
    }

    private void printInstructions() {
        System.out.println("Instructions:");
        System.out.println("1. Who is head of department {department_name}");
        System.out.println("2. Show {department_name} statistics");
        System.out.println("3. Show the average salary for the department {department_name}");
        System.out.println("4. Show count of employee for {department_name}");
        System.out.println("5. Global search by {template}");
        System.out.println("--------------------------------------------------");
    }

}
