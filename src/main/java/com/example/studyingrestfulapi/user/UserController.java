package com.example.studyingrestfulapi.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    // 생성자로 의존성 주입
    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<UserAll> retrieveAllUsers() {
        return service.findAll();   //전체 사용자목록 반환
    }

    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable int id) {
        UserAll user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        //HATEOAS
        EntityModel<UserAll> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        //import static 사용하면 class명을 쓰지 않아 코드를 더 줄일 수 있음
        entityModel.add(linkTo.withRel("all-users"));
        //all-users와 retrieveAllUsers를 연결

        //필터링 기능 추가
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");

        //사용 가능한 필터로 만들기
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);
        mapping.setFilters(filters);

        //전체 사용자 보기 링크를 추가하여 리턴함
        return mapping;

//        return entityModel;
    }

    //생성 Post 요청시 사용
    //@RequestBody로 데이터(json 형태) 전달받는다
    @PostMapping("/users")
    public ResponseEntity<UserAll> createUser(@Valid @RequestBody UserAll user) {
        UserAll savedUser = service.save(user);

        //사용자에게 요청값 반환 201 status
        //여기 id에 무슨 값이 들어가는지 어떻게 알아
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        UserAll user = service.deleteUserById(id);

        if (user == null ) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }
}
