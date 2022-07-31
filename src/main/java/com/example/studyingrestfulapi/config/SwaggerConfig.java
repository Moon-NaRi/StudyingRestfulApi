package com.example.studyingrestfulapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact("yujin", "http://www.naver.com/blog/code11298",
            "code11298@naver.com");

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Restful API",
            "User management REST API Service", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());

    private static final Set<String> DEFAULT_PRODUCE_AND_CONSUMES = new HashSet<>(
            Arrays.asList("application/json", "application/xml"));


    @Bean
    public Docket api() {
        //api에 관련된 문서정보
        //http://localhost:8088/v2/api-docs     //json 페이지
        //http://localhost:8088/swagger-ui/index.html   //document 페이지
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCE_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCE_AND_CONSUMES);
    }
}
