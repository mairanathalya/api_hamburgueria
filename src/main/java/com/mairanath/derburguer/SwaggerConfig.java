package com.mairanath.derburguer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.mairanath.derburguer"))
                .paths(PathSelectors.regex("/.*")).build().
                apiInfo((apiInfoMetaData())).securitySchemes(List.of(new ApiKey("JWT", HttpHeaders.AUTHORIZATION, "Bearer")))
                .securityContexts(List.of(securityContext()));
    }
    private ApiInfo apiInfoMetaData() {

        return new ApiInfoBuilder().title("Derbuguer")
                .description("API Endpoint para teste")
                .contact(new Contact("Dev-Team", "", "maira.nathalya@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes [0] = authorizationScope;
        return List.of(new SecurityReference("JWT" , authorizationScopes));

    }

}
