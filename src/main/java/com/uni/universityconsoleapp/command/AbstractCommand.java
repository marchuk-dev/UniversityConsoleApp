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

}