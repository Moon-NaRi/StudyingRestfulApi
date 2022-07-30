package com.example.studyingrestfulapi.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value = {"password", "ssno"})   //json 전달 무시
@JsonFilter("UserInfo") //임의의 필터값 부여
public class User {
    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력하십시오.")
    private String name;
    @Past
    private Date joinDate;  //import필요

//    @JsonIgnore //data 값을 무시해주세요 json으로 전달 안됨
    private String password;
//    @JsonIgnore
    private String ssno;
}
