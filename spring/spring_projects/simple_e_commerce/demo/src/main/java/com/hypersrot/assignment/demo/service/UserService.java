package com.hypersrot.assignment.demo.service;

import com.hypersrot.assignment.demo.entity.User;
import com.hypersrot.assignment.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveTheUser(User user) {
        this.userRepository.save(user);
    }

    public void saveAllUsers(List<User> users) {
        this.userRepository.saveAll(users);
    }

}
