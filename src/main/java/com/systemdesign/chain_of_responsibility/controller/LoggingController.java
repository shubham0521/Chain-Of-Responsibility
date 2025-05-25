package com.systemdesign.chain_of_responsibility.controller;

import com.systemdesign.chain_of_responsibility.logging.LogLevel;
import com.systemdesign.chain_of_responsibility.model.LogMessageRequest;
import com.systemdesign.chain_of_responsibility.service.LoggingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for handling logging operations.
 * This controller provides endpoints for logging messages at different levels
 * using the chain of responsibility pattern.
 */
@RestController
@RequestMapping("/api/logs")
@Tag(name = "Logging Controller", description = "APIs for logging messages with different log levels")
public class LoggingController {
    /** The logging service that processes the log messages */
    private final LoggingService loggingService;

    /**
     * Constructs a new LoggingController with the provided logging service.
     * The logging service is injected by Spring's dependency injection.
     *
     * @param loggingService The service that handles logging operations
     */
    public LoggingController(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    /**
     * Logs a message with the specified log level.
     * The message will be processed by all loggers in the chain that can handle
     * the specified level.
     *
     * @param level The log level (INFO, DEBUG, or ERROR)
     * @param request The request containing the message to be logged
     * @return A response indicating the success of the operation
     */
    @Operation(summary = "Log a message with specified log level", 
               description = "Logs a message with the specified log level (INFO, DEBUG, or ERROR)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Message logged successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid log level or message")
    })
    @PostMapping("/{level}")
    public ResponseEntity<String> logMessage(
            @Parameter(description = "Log level (INFO, DEBUG, ERROR)", required = true)
            @PathVariable LogLevel level,
            @Parameter(description = "Message to be logged", required = true)
            @RequestBody LogMessageRequest request) {
        loggingService.logMessage(level, request.getMessage());
        return ResponseEntity.ok("Message logged successfully");
    }

    /**
     * Logs a message with INFO level.
     * This is a convenience endpoint that logs messages at INFO level.
     *
     * @param request The request containing the message to be logged
     * @return A response indicating the success of the operation
     */
    @Operation(summary = "Log an info message", 
               description = "Logs a message with INFO level")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Info message logged successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid message")
    })
    @PostMapping("/info")
    public ResponseEntity<String> logInfo(
            @Parameter(description = "Message to be logged", required = true)
            @RequestBody LogMessageRequest request) {
        loggingService.logInfo(request.getMessage());
        return ResponseEntity.ok("Info message logged successfully");
    }

    /**
     * Logs a message with DEBUG level.
     * This is a convenience endpoint that logs messages at DEBUG level.
     *
     * @param request The request containing the message to be logged
     * @return A response indicating the success of the operation
     */
    @Operation(summary = "Log a debug message", 
               description = "Logs a message with DEBUG level")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Debug message logged successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid message")
    })
    @PostMapping("/debug")
    public ResponseEntity<String> logDebug(
            @Parameter(description = "Message to be logged", required = true)
            @RequestBody LogMessageRequest request) {
        loggingService.logDebug(request.getMessage());
        return ResponseEntity.ok("Debug message logged successfully");
    }

    /**
     * Logs a message with ERROR level.
     * This is a convenience endpoint that logs messages at ERROR level.
     *
     * @param request The request containing the message to be logged
     * @return A response indicating the success of the operation
     */
    @Operation(summary = "Log an error message", 
               description = "Logs a message with ERROR level")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Error message logged successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid message")
    })
    @PostMapping("/error")
    public ResponseEntity<String> logError(
            @Parameter(description = "Message to be logged", required = true)
            @RequestBody LogMessageRequest request) {
        loggingService.logError(request.getMessage());
        return ResponseEntity.ok("Error message logged successfully");
    }
} 