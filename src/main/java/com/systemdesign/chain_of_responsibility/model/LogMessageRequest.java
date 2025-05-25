package com.systemdesign.chain_of_responsibility.model;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Request model for logging messages.
 * This class represents the structure of the request body for logging endpoints.
 */
@Schema(description = "Request model for logging messages")
public class LogMessageRequest {
    /**
     * The message to be logged.
     * This field is required and should contain the actual message content.
     */
    @Schema(description = "The message to be logged", 
            example = "This is a sample log message", 
            required = true)
    private String message;

    /**
     * Default constructor required for JSON deserialization.
     */
    public LogMessageRequest() {
    }

    /**
     * Constructs a new LogMessageRequest with the specified message.
     *
     * @param message The message to be logged
     */
    public LogMessageRequest(String message) {
        this.message = message;
    }

    /**
     * Gets the message to be logged.
     *
     * @return The message content
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message to be logged.
     *
     * @param message The message content to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
} 