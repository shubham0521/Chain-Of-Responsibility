package com.systemdesign.chain_of_responsibility.service;

import com.systemdesign.chain_of_responsibility.logging.LogLevel;

/**
 * Service interface for logging operations.
 * This interface defines the contract for logging messages at different levels
 * using the chain of responsibility pattern.
 */
public interface LoggingService {
    /**
     * Logs a message with the specified log level.
     * The message will be processed by all loggers in the chain that can handle
     * the specified level.
     *
     * @param level The log level of the message
     * @param message The message to be logged
     */
    void logMessage(LogLevel level, String message);

    /**
     * Logs a message with INFO level.
     * This is a convenience method that calls {@link #logMessage(LogLevel, String)}
     * with LogLevel.INFO.
     *
     * @param message The informational message to be logged
     */
    void logInfo(String message);

    /**
     * Logs a message with DEBUG level.
     * This is a convenience method that calls {@link #logMessage(LogLevel, String)}
     * with LogLevel.DEBUG.
     *
     * @param message The debug message to be logged
     */
    void logDebug(String message);

    /**
     * Logs a message with ERROR level.
     * This is a convenience method that calls {@link #logMessage(LogLevel, String)}
     * with LogLevel.ERROR.
     *
     * @param message The error message to be logged
     */
    void logError(String message);
} 