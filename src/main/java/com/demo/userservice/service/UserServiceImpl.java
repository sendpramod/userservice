package com.demo.userservice.service;

import com.demo.userservice.model.User;
import com.demo.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User findUserByUserId(String userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        return userOptional.orElseGet(() -> null);
    }

    @Override
    public User onBoardUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
