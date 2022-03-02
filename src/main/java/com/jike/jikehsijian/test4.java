package com.jike.jikehsijian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Optional操作demo
 * @description
 * @author kylin
 * @date 2021/8/19 14:52
 **/
public class test4 {


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User{
        String email;
        String pwd;

        public User(String email, String pwd) {
            this.email = email;
            this.pwd = pwd;
        }

        private String position;

        public Optional<String> getPosition() {
            return Optional.ofNullable(position);
        }
    }


    @Test
    public void t1(){
        User user = new User("960696989@qq.com", "123");
        User user1 = new User();
        String email = Optional.ofNullable(user1).map(u -> u.getEmail()).orElse("default@qq.com");
        System.out.println(email);//default@qq.com
    }


    @Test
    public void t2(){
        User user = new User("anna@gmail.com", "1234");
        Optional<User> result = Optional.ofNullable(user)
                .filter(u -> u.getEmail() != null && u.getEmail().contains("@"));

        boolean present = result.isPresent();
        System.out.println(present);
    }

    @Test
    public void t3(){
        User user = new User("anna@gmail.com", "1234");
       User user1 = Optional.ofNullable(user)
               .filter(u -> u.getEmail() != null && u.getEmail().contains("@"))
               .orElse(new User());
       System.out.println(user1.toString());

   }

    @Test
    public void t4(){
        User user = new User("anna@gmail.com", "1234");

        String result = Optional.ofNullable(user)
                .flatMap(u -> u.getPosition())
                .orElse("default");

        System.out.println(result);
    }


}
