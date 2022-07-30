package com.example.studyingrestfulapi.user;

// HTTP Status Code
// 2xx -> Ok
// 4xx -> Client Error
// 5xx -> Server Error

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)   //존재하지 않을 경우 에러코드
public class UserNotFoundException extends RuntimeException {   //실행시 발생하는 오류
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
