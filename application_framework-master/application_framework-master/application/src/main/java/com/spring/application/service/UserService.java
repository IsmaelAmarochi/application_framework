package com.spring.application.service;

import com.spring.application.model.Category;
import com.spring.application.model.User;
import com.spring.application.repository.UserRepository;

//Service for all the User based operations
public class UserService {

    UserRepository userRepository;

    //Add a specific user
    public void addUser(User user){
        userRepository.save(user);
    }
}
