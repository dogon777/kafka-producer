package com.dakbangla.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Demo of Kafka Producer and Consumer along with OpenAPI 3")
                .description("Demo of Kafka Producer and Consumer along with OpenAPI 3. Replacement of Swagger with OpenAPI 3")
                .version("0.0.1-SNAPSHOT")
                .contact(apiContact())
                .license(apiLicence());
    }

    private License apiLicence() {
        return new License()
                .name("MIT Licence")
                .url("https://opensource.org/licenses/mit-license.php");
    }

    private Contact apiContact() {
        return new Contact()
                .name("Springtime developers")
                .email("springtime@hotmail.com")
                .url("https://github.com/springtime");
    }
}
