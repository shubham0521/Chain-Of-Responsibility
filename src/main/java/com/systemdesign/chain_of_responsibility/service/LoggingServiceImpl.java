package com.systemdesign.chain_of_responsibility.service;

import com.systemdesign.chain_of_responsibility.logging.AbstractLogger;
import com.systemdesign.chain_of_responsibility.logging.LogLevel;
import org.springframework.stereotype.Service;

/**
 * Implementation of the LoggingService interface.
 * This service uses the chain of responsibility pattern to process log messages
 * through a chain of loggers, each handling messages at different levels.
 */
@Service
public class LoggingServiceImpl implements LoggingService {
    /** The chain of loggers that will process the messages */
    private final AbstractLogger loggerChain;

    /**
     * Constructs a new LoggingServiceImpl with the provided logger chain.
     * The logger chain is injected by Spring's dependency injection.
     *
     * @param loggerChain The chain of loggers to process messages
     */
    public LoggingServiceImpl(AbstractLogger loggerChain) {
        this.loggerChain = loggerChain;
    }

    /**
     * {@inheritDoc}
     * Processes the message through the chain of loggers, allowing each logger
     * to handle the message based on its level.
     */
    @Override
    public void logMessage(LogLevel level, String message) {
        loggerChain.logMessage(level, message);
    }

    /**
     * {@inheritDoc}
     * Logs an informational message by calling logMessage with LogLevel.INFO.
     */
    @Override
    public void logInfo(String message) {
        logMessage(LogLevel.INFO, message);
    }

    /**
     * {@inheritDoc}
     * Logs a debug message by calling logMessage with LogLevel.DEBUG.
     */
    @Override
    public void logDebug(String message) {
        logMessage(LogLevel.DEBUG, message);
    }

    /**
     * {@inheritDoc}
     * Logs an error message by calling logMessage with LogLevel.ERROR.
     */
    @Override
    public void logError(String message) {
        logMessage(LogLevel.ERROR, message);
    }
} 