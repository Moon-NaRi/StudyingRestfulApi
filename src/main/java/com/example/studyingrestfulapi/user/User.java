package com.example.studyingrestfulapi.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor  //상속을 위해 디폴트 생성자 선언
//@JsonIgnoreProperties(value = {"password", "ssno"})   //json 전달 무시
@JsonFilter("UserInfo") //임의의 필터값 부여
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
public class User {
    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력하십시오.")
    @ApiModelProperty(notes = "사용자 이름을 입력하세요.")
    private String name;
    @Past
    @ApiModelProperty(notes = "사용자의 가입일을 입력하세요.")
    private Date joinDate;  //import필요

//    @JsonIgnore //data 값을 무시해주세요 json으로 전달 안됨
    @ApiModelProperty(notes = "사용자의 비밀번호를 입력하세요.")
    private String password;
//    @JsonIgnore
    @ApiModelProperty(notes = "사용자의 주민번호를 입력하세요.")
    private String ssno;
}
