package com.credable.app.middleware_service.config;



import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${openapi.info.title}")
    private String title;

    @Value("${openapi.info.description}")
    private String description;

    @Value("${openapi.info.version}")
    private String version;

    @Value("${openapi.info.terms-of-service}")
    private String termsOfService;

    @Value("${openapi.info.contact.name}")
    private String contactName;

    @Value("${openapi.info.contact.email}")
    private String contactEmail;

    @Value("${openapi.info.contact.url}")
    private String contactUrl;

    @Value("${openapi.info.license.name}")
    private String licenseName;

    @Value("${openapi.info.license.url}")
    private String licenseUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("basicAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("basic")
                                        .description("Basic authentication for API access")))
                .info(new Info()
                        .title(title)
                        .description(description)
                        .version(version)
                        .termsOfService(termsOfService)
                        .contact(new Contact()
                                .name(contactName)
                                .email(contactEmail)
                                .url(contactUrl))
                        .license(new License()
                                .name(licenseName)
                                .url(licenseUrl)));
    }
}
