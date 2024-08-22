package com.uni.universityconsoleapp.command;

public interface Command {

    /**
     * Executes the command based on the given input.
     *
     * @param input the input string that triggers the command.
     */
    void execute(String input);

    /**
     * Checks if the command might be executed based on the given input.
     *
     * @param input the input string to check.
     * @return true if the command can handle the input; false otherwise.
     */
    boolean canExecute(String input);

    /**
     * Provides the request message that this command listens for.
     *
     * @return the request message as a string.
     */
    String getRequestMessage();

    /**
     * Extracts and returns the formatted request value from the given input string.
     * <p>
     * This method removes the predefined request message from the input string and trims any leading or trailing
     * whitespace to isolate the relevant part of the input. This is useful for extracting parameters or values
     * specified by the user after the command keyword.
     * </p>
     *
     * @param input The input string containing the full command, including the request message.
     * @return The formatted request value, which is the portion of the input string following the request message,
     * with leading and trailing whitespace removed.
     */
    String getFormattedRequest(String input);

}
