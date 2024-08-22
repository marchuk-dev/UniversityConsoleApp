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
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            commandDispatcher.dispatch(input);
        }
    }
}
