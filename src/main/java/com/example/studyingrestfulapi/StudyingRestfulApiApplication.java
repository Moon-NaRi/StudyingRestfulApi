package com.example.studyingrestfulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class StudyingRestfulApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyingRestfulApiApplication.class, args);
    }

    //초기화시 메모리에 올라감
    @Bean
    public LocaleResolver localeResolver() {
        //한국어 기본 처리 추가
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREA);
        return localeResolver;
    }
}
