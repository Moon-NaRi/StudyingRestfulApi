package com.example.studyingrestfulapi.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

//관리자 관련 API
@RestController
@RequestMapping("/admin")   //Mapping 공통부분
public class AdminUserController {
    private UserDaoService service;

    // 생성자로 의존성 주입
    public AdminUserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {
        List<UserAll> users = service.findAll();

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "ssno", "password");
        //보려는 데이터만 추가함

        //사용 가능한 필터로 만들기
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filters);

        return mapping;   //전체 사용자목록 반환
    }

    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable int id) {
        UserAll user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        SimpleBeanPropertyFilter filter = 
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "ssno", "password");
        //보려는 데이터만 추가함

        //사용 가능한 필터로 만들기
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
        
        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);
        
        return mapping; //필터 된 값 반환
    }

    //버전 생성
    @GetMapping("/users/ver1/{id}")
    public MappingJacksonValue retrieveUser1(@PathVariable int id) {
        UserAll user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        //반환 받은 User 값을 User2로 변환한다
        UserVer2 user2 = new UserVer2();
        BeanUtils.copyProperties(user, user2); //user data 5가지를 가짐
        user2.setGrade("VIP");

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "grade");
        //보려는 데이터만 추가함

        //사용 가능한 필터로 만들기
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoVer2", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping; //필터 된 값 반환
    }

    //파라미터로 버전 관리
    //http://localhost:8088/admin/users/1/?version=1
    @GetMapping(value = "/users/{id}/", params = "version=1")
    public MappingJacksonValue retrieveUser2(@PathVariable int id) {
        UserAll user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "ssno", "password");
        //보려는 데이터만 추가함

        //사용 가능한 필터로 만들기
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping; //필터 된 값 반환
    }

    //헤더로 버전 관리 PostMan header에 추가
    //일반 브라우저에서는 실행 불가능함
    //http://localhost:8088/admin/users/1
    @GetMapping(value = "/users/{id}", headers = "Api-Version=1")
    public MappingJacksonValue retrieveUser3(@PathVariable int id) {
        UserAll user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "ssno", "password");
        //보려는 데이터만 추가함

        //사용 가능한 필터로 만들기
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping; //필터 된 값 반환
    }

    //MIME로 버전 관리 PostMan header에 추가
    //일반 브라우저에서는 실행 불가능함
    //http://localhost:8088/admin/users/1
    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv1+json")
    public MappingJacksonValue retrieveUser4(@PathVariable int id) {
        UserAll user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "ssno", "password");
        //보려는 데이터만 추가함

        //사용 가능한 필터로 만들기
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping; //필터 된 값 반환
    }
}
