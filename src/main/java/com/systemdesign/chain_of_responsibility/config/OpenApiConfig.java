package com.systemdesign.chain_of_responsibility.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for OpenAPI (Swagger) documentation.
 * This class sets up the API documentation with metadata about the logging system,
 * including title, description, version, contact information, and license details.
 */
@Configuration
public class OpenApiConfig {

    /**
     * Creates and configures the OpenAPI documentation for the logging system.
     * The documentation includes:
     * - API title and description
     * - Version information
     * - Contact details for the development team
     * - License information
     *
     * @return The configured OpenAPI documentation
     */
    @Bean
    public OpenAPI loggingOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Logging System API")
                        .description("REST API for the Chain of Responsibility Logging System")
                        .version("1.0")
                        .contact(new Contact()
                                .name("System Design Team")
                                .email("team@example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
} 