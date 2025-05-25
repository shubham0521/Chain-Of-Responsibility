package com.systemdesign.chain_of_responsibility.config;

import com.systemdesign.chain_of_responsibility.logging.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up the logger chain.
 * This class creates and configures the chain of responsibility for loggers,
 * establishing the order in which loggers process messages.
 */
@Configuration
public class LoggerConfig {
    
    /**
     * Creates and configures the chain of loggers.
     * The chain is set up in the following order:
     * 1. ErrorLogger (highest priority)
     * 2. DebugLogger
     * 3. InfoLogger (lowest priority)
     *
     * @return The configured chain of loggers, with ErrorLogger as the head
     */
    @Bean
    public AbstractLogger loggerChain() {
        AbstractLogger errorLogger = new ErrorLogger();
        AbstractLogger debugLogger = new DebugLogger();
        AbstractLogger infoLogger = new InfoLogger();

        // Set up the chain
        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        return errorLogger;
    }
} 