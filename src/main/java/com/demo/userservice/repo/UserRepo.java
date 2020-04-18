package com.demo.userservice.repo;

import com.demo.userservice.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, String> {
    User findUserByEmailIdAndMobileNo(String emailId, String mobileNo);
}
