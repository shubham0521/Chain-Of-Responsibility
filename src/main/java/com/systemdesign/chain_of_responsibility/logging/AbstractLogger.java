package com.systemdesign.chain_of_responsibility.logging;

/**
 * Abstract base class for all loggers in the chain of responsibility pattern.
 * This class defines the common structure and behavior for all concrete loggers.
 * Each logger in the chain can process messages based on its log level and
 * pass the message to the next logger in the chain.
 */
public abstract class AbstractLogger {
    /** The log level associated with this logger */
    protected LogLevel level;
    
    /** Reference to the next logger in the chain */
    protected AbstractLogger nextLogger;

    /**
     * Sets the next logger in the chain of responsibility.
     *
     * @param nextLogger The logger that should process the message if this logger doesn't handle it
     */
    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    /**
     * Processes a log message through the chain of responsibility.
     * If this logger can handle the message (based on log level), it writes the message.
     * Then, it passes the message to the next logger in the chain.
     *
     * @param level The log level of the message
     * @param message The message to be logged
     */
    public void logMessage(LogLevel level, String message) {
        if (shouldLog(level)) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    /**
     * Determines if this logger should process the given log level.
     * A logger should process a message if the requested level is greater than or equal to its level.
     * For example:
     * - If logger is INFO (0) and requested level is ERROR (2), should log
     * - If logger is DEBUG (1) and requested level is ERROR (2), should log
     * - If logger is ERROR (2) and requested level is INFO (0), should not log
     *
     * @param requestedLevel The log level of the message being processed
     * @return true if this logger should process the message, false otherwise
     */
    protected boolean shouldLog(LogLevel requestedLevel) {
        // A logger should process the message if the requested level is greater than or equal to its level
        // For example:
        // - If logger is INFO (0) and requested level is ERROR (2), should log
        // - If logger is DEBUG (1) and requested level is ERROR (2), should log
        // - If logger is ERROR (2) and requested level is INFO (0), should not log
        return getLevelValue(requestedLevel) >= getLevelValue(level);
    }

    /**
     * Converts a LogLevel enum to its numeric value for comparison.
     * ERROR = 2 (highest priority)
     * DEBUG = 1
     * INFO = 0 (lowest priority)
     *
     * @param level The log level to convert
     * @return The numeric value of the log level
     */
    private int getLevelValue(LogLevel level) {
        switch (level) {
            case ERROR: return 2;
            case DEBUG: return 1;
            case INFO: return 0;
            default: return -1;
        }
    }

    /**
     * Abstract method that concrete loggers must implement to write the log message.
     * Each concrete logger can implement its own way of writing the message
     * (e.g., to console, file, database, etc.).
     *
     * @param message The message to be written
     */
    protected abstract void write(String message);
} 