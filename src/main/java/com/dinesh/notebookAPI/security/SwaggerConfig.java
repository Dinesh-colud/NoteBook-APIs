package com.dinesh.notebookAPI.security;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPT(){

        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("NoteBook APIs")
                        .version("V1.0")
                        .description("REST API for managing notes using Spring Boot, Spring Security and JWT Authentication")
                        .contact(new Contact()
                                .name("Dinesh Rajbhar")
                                .email("johndoe@gmail.com")
                        )
                ).addSecurityItem(new SecurityRequirement().addList(securitySchemeName)
                ).schemaRequirement(
                        securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                );
    }

}
