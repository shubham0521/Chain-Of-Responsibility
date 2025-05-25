package com.systemdesign.chain_of_responsibility.logging;

/**
 * Enum representing different log levels in the logging system.
 * The levels are ordered by severity, with ERROR being the most severe
 * and INFO being the least severe.
 * 
 * The numeric values associated with each level are:
 * - ERROR: 2 (highest priority)
 * - DEBUG: 1
 * - INFO: 0 (lowest priority)
 */
public enum LogLevel {
    /** Informational messages for general application flow */
    INFO,
    
    /** Debug messages for development and troubleshooting */
    DEBUG,
    
    /** Error messages for serious issues that need attention */
    ERROR
} 