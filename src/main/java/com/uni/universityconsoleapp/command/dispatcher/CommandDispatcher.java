package com.uni.universityconsoleapp.command.dispatcher;

import com.uni.universityconsoleapp.command.Command;
import com.uni.universityconsoleapp.exceptions.DepartmentNotFoundException;
import com.uni.universityconsoleapp.exceptions.LectorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandDispatcher {

    private final List<Command> commands;

    public void dispatch(String input) {
        for (Command command : commands) {
            if (command.canExecute(input)) {
                try {
                    command.execute(input);
                } catch (LectorNotFoundException | DepartmentNotFoundException exception) {
                    System.out.println(exception.getMessage());
                }

                return;
            }
        }
        System.out.println("Unknown command.");
    }
}
