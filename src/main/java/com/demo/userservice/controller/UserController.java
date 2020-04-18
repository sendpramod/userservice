package com.demo.userservice.controller;

import com.demo.userservice.exception.DataNotFoundException;
import com.demo.userservice.model.User;
import com.demo.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.debug("Create User payload: {0}", user != null ? user.toString() : null);
        return userService.onBoardUser(user);
    }
    @GetMapping
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable("userId") String userId, @RequestBody User user) {
        logger.debug("Updating User by Id {0} with new payload: {1}", userId, user != null ? user.toString() : null);
        user.setUserId(userId);
        return userService.onBoardUser(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        logger.debug("Finding User by Id {0} ", userId);
        User user = userService.findUserByUserId(userId);
        if (user == null) {
            throw new DataNotFoundException("User does not exists");
        }
        return user;
    }
    @GetMapping("/emailormob")
    public User getUserByEmailOrMobile(@Param("emailId") String emailId,@Param("mobile") String mobile) {
        User user = userService.findUserByEmailOrMobileNo(emailId,mobile);
        if (user == null) {
            throw new DataNotFoundException("User does not exists");
        }
        return user;
    }


}
