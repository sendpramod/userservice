package com.demo.userservice.service;

import com.demo.userservice.model.User;

import java.util.List;

public interface UserService {
    public User findUserByUserId(String userId);

    public User onBoardUser(User user);

    public List<User> getAllUsers();
}
