package com.api.greenway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI OpenApiConfiguration() {
        return new OpenAPI()
                .info(new Info()
                        .title("Greenway - API")
                        .version("0.1.0")
                        .description("API do Greenway, uma inovadora plataforma SaaS projetada para auxiliar empresas na gestão de suas operações rumo à sustentabilidade")
                        .contact(new Contact()
                                .email("technosfiap@gmail.com")
                                .name("GitHub Technos")
                                .url("https://github.com/greenway-FIAP"))
                        .license(new License()));
    }
}
