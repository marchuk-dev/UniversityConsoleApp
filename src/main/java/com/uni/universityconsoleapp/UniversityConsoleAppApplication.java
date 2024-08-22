package com.uni.universityconsoleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UniversityConsoleAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UniversityConsoleAppApplication.class, args);
        ConsoleApp consoleApp = context.getBean(ConsoleApp.class);
        consoleApp.run();
    }

}
