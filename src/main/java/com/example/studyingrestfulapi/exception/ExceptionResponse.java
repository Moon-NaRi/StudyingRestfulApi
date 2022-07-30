package com.example.studyingrestfulapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {    //예외처리 클래스
    private Date timestamp;
    private String msg;
    private String details;
}
