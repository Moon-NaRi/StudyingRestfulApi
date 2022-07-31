package com.example.studyingrestfulapi.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password", "ssno"})   //json 전달 무시
@JsonFilter("UserInfoVer2") //임의의 필터값 부여
public class UserVer2 extends UserAll {
    private String grade;
}
