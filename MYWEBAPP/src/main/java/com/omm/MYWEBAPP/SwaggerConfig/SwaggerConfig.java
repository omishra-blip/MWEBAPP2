package com.omm.MYWEBAPP.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(new io.swagger.v3.oas.models.info.Info()
                            .title("MY WEB APP")
                            .description("This is a sample Spring Boot RESTful Web Service using Swagger 3.")
                            .version("v1.0.0"));
        }

}
