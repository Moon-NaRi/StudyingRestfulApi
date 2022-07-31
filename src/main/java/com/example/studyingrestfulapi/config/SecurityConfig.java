package com.example.studyingrestfulapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration  //서버 켜지면서 메모리에 설정정보 같이 로딩함
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired    //질문작성필요
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("yujin")
                .password("1234")
                .roles("USER");
    }
}
