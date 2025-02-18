package br.com.BrayanFJ.ApiControleDeContatos.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicScheme",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info()
                        .title("API Controle de Contatos")
                        .description("API para controle de contatos, gestão de informações e comunicação.")
                        .contact(new Contact().name("Brayan Fernandes")
                                .email("brayan.fernandesjulio@gmail.com")
                                .url("https://github.com/BrayanFj"))
                        .version("1.0.0"));
    }
}