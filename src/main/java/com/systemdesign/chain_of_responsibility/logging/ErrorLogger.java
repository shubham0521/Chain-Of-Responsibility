package com.systemdesign.chain_of_responsibility.logging;

/**
 * Concrete logger implementation for ERROR level messages.
 * This logger handles error messages for serious issues that need attention.
 * It writes messages to the standard error stream.
 */
public class ErrorLogger extends AbstractLogger {
    /**
     * Constructs a new ErrorLogger and sets its log level to ERROR.
     */
    public ErrorLogger() {
        this.level = LogLevel.ERROR;
    }

    /**
     * Writes an error message to the standard error stream.
     * The message is prefixed with "ERROR: " to indicate its level.
     *
     * @param message The error message to be written
     */
    @Override
    protected void write(String message) {
        System.err.println("ERROR: " + message);
    }
} 