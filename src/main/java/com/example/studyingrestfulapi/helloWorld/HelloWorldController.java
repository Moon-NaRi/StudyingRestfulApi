package com.example.studyingrestfulapi.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//xml이 아니라 어노테이션으로 컨트롤러를 지원함
//view를 갖지 않는 Rest Data(json/xml)을 반환
//기존 Spring에서는 ResponseBody 형태로 반환해야 했는데
//RestController는 Controller와 ResponseBody 역할을 모두 해서 클라이언트로 바로 반환
@RestController
public class HelloWorldController {
    //Get방식
    // /hello-world endpoint
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "hello world";
    }

    // bean 반환 json 형태.. xml로 하고싶으면 라이브러리 다른거 써야함
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    // 가변데이터
    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
