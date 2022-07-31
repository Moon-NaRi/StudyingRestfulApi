package com.example.studyingrestfulapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        //api에 관련된 문서정보
        //http://localhost:8088/v2/api-docs     //json 페이지
        //http://localhost:8088/swagger-ui/index.html   //document 페이지
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
