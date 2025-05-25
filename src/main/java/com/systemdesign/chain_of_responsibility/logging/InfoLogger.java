package com.systemdesign.chain_of_responsibility.logging;

/**
 * Concrete logger implementation for INFO level messages.
 * This logger handles informational messages about the general flow of the application.
 * It writes messages to the standard output stream.
 */
public class InfoLogger extends AbstractLogger {
    /**
     * Constructs a new InfoLogger and sets its log level to INFO.
     */
    public InfoLogger() {
        this.level = LogLevel.INFO;
    }

    /**
     * Writes an informational message to the standard output stream.
     * The message is prefixed with "INFO: " to indicate its level.
     *
     * @param message The informational message to be written
     */
    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
} 