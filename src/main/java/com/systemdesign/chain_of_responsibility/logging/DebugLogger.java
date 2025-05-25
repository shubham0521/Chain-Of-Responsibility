package com.systemdesign.chain_of_responsibility.logging;

/**
 * Concrete logger implementation for DEBUG level messages.
 * This logger handles debug messages used for development and troubleshooting.
 * It writes messages to the standard output stream.
 */
public class DebugLogger extends AbstractLogger {
    /**
     * Constructs a new DebugLogger and sets its log level to DEBUG.
     */
    public DebugLogger() {
        this.level = LogLevel.DEBUG;
    }

    /**
     * Writes a debug message to the standard output stream.
     * The message is prefixed with "DEBUG: " to indicate its level.
     *
     * @param message The debug message to be written
     */
    @Override
    protected void write(String message) {
        System.out.println("DEBUG: " + message);
    }
} 