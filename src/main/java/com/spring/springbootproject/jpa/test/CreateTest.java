package com.spring.springbootproject.jpa.test;

import com.spring.springbootproject.SpringbootprojectApplication;
import com.spring.springbootproject.jpa.dao.UserRepository;
import com.spring.springbootproject.jpa.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class CreateTest {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootprojectApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        User user = new User(1, "shakti");
        User user1 = new User(2, "Sahil");
        List<User> list = List.of(user, user1);
        list = (List<User>) userRepository.saveAll(list);

        System.out.println(list);

    }
}
