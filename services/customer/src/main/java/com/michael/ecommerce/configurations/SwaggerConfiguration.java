package com.michael.ecommerce.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customeOpenApi() {
        return new OpenAPI()
                .info(new Info().title("Customer Service api")
                        .version("1.0")
                        .description("This is a swagger to manage api for Customer Service"));
    }
}
