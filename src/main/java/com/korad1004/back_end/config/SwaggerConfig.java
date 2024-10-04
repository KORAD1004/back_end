package com.korad1004.back_end.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;


@OpenAPIDefinition(
        info = @Info(title = "Nuclear", description = "원자력발전소 공모전", version = "v1"),
        servers = {
                @Server(url = "https://dev.smartcheers.site", description = "서버 URL"),
                @Server(url = "http://localhost:8080", description = "로컬 URL")

                        }

)
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi SwaggerOpenApi() {
        return GroupedOpenApi.builder()
                .group("Swagger-api")
                .pathsToMatch("/api/**")
                .build();
    }
}
