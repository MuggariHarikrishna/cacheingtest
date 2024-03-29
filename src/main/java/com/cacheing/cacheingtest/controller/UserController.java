package com.cacheing.cacheingtest.controller;

import com.cacheing.cacheingtest.model.User;
import com.cacheing.cacheingtest.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    public UserServiceImpl userServiceImpl;

    @GetMapping("/user/test")
    public String hello() {
        return "Hello From Quarkus";
    }


    @GetMapping("/user/{userId}")
    public String getBooks(@PathVariable("userId") int userId) {
        return userServiceImpl.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteBook(@PathVariable("userId") int userId) {
        userServiceImpl.delete(userId);
    }

    @PostMapping("/user/")
    public String addUser(@RequestBody User user) {
        userServiceImpl.saveOrUpdate(user.getUserId(), user.getUserName());
        return "User with userId " + user.getUserId() + " Added";
    }
}
