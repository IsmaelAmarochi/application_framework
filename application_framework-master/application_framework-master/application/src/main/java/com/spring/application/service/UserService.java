package com.spring.application.service;

import com.spring.application.model.Category;
import com.spring.application.model.User;
import com.spring.application.repository.UserRepository;

public class UserService {

    UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }
}
