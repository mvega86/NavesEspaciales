package com.pruebaTecnica.spaceShips.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Naves Espaciales",
                version = "1.0.0",
                description = "Prueba técnica de naves espaciales con Spring Boot"
        )
)
public class OpenApiConfig {
}
