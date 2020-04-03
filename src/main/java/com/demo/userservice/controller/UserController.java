package com.demo.userservice.controller;

import com.demo.userservice.exception.DataNotFoundException;
import com.demo.userservice.model.User;
import com.demo.userservice.repo.UserRepo;
import com.demo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.onBoardUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.onBoardUser(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        User user = userService.findUserByUserId(userId);
        if (user == null) {
            throw new DataNotFoundException("User does not exists");
        }
        return user;
    }

}
