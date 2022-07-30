package com.example.studyingrestfulapi.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// @Service or @Component 사용
@Service
public class UserDaoService {
    //비즈니스 로직 관련

    //DB역할을 하는 ArrayList
    private  static List<User> users = new ArrayList<>();

    //static으로 선언하여 프로그램이 시작될 때 할당함.. 함수가 끝나도 사용 가능
    //단 여기 파일에서만 사용 가능(정보은닉)
    private static int usersCount = 3;

    static {
        users.add(new User(1, "yujin", new Date()));
        users.add(new User(2, "yujun", new Date()));
        users.add(new User(3, "yujan", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        for(User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        //DB에 존재하지 않는 id를 요청했을 경우 예외처리가 필요
        return null;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }
    
    //삭제
    public User deleteUserById(int id) {
        Iterator<User> iterator = users.iterator(); //순차적인 결과값
        
        while (iterator.hasNext()) {
            User user = iterator.next();
            
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        
        // 삭제할 데이터가 없을 경우
        return null;
    }
}
