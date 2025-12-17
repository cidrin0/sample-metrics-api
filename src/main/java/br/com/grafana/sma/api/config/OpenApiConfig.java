package br.com.grafana.sma.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Metrics API",
                version = "1.0",
                description = "Sandbox Project to Test Metrics"
        )
)
public class OpenApiConfig {


}