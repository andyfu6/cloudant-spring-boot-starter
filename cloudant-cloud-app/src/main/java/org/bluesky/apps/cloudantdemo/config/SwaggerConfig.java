package org.bluesky.apps.cloudantdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("org.bluesky.apps.cloudantdemo.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Andy Fu", null, "767970341@qq.com");
        return new ApiInfoBuilder().title("Cloudant Demo")
                .contact(contact).version("1.0").description("Cloudant Demo API").build();
    }
}
