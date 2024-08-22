package com.uni.universityconsoleapp.command.dispatcher;

import com.uni.universityconsoleapp.command.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandDispatcher {

    private final List<Command> commands;

    public void dispatch(String input) {
        for (Command command : commands) {
            if (command.isExecuted(input)) {
                command.execute(input);
                return;
            }
        }
        System.out.println("Unknown command.");
    }
}
