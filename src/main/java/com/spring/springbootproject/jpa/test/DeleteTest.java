package com.spring.springbootproject.jpa.test;

import com.spring.springbootproject.SpringbootprojectApplication;
import com.spring.springbootproject.jpa.dao.UserRepository;
import com.spring.springbootproject.jpa.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

public class DeleteTest {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootprojectApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        Optional<User> user = userRepository.findById(2);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            System.out.println("Object Deleted");
        } else {
            System.out.println("Object Not Found");
        }
    }
}
