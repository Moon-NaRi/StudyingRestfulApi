package com.example.studyingrestfulapi.helloWorld;

//lombok - 여러 코드를 자동으로 생성해서 코딩하기가 편리함
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //생성자 자동생성해줌
@NoArgsConstructor //default 생성자가 생성됨
public class HelloWorldBean {
    private String msg; //lombok 써서 getter, setter 생성 안해도됨

    //lombok을 사용해서
    //생성자, getter, setter 등등이 없어도 알아서 됨 structure 에서 확인가능
    //annotation processing을 활성화해야 lombok의 기능을 잘 쓸수 있음

    //constructor HelloWorldBean(java.lang.String) is already defined
//    public HelloWorldBean(String msg) {
//        this.msg = msg;
//    }
}
