package com.notes.datagitaretriever.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {



    @Bean
    OpenAPI usersMicroserviceOpenAPI() {

        Server localhost = new Server();
        localhost.setUrl("http://localhost:8080");
        localhost.setDescription("Development environment");

        Contact contact = new Contact();
        contact.setEmail("somitdas@gmail.com");
        contact.setName("Event Management");
        contact.setUrl("http://localhost:8080/datagita");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info().title("ApplicationName RESTful Web Service documentation").version("0.1").contact(contact)
                .description("This API exposes endpoints to manage Application for Event Management.")
                .termsOfService("https://domainname/terms").license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(localhost));
    }

}