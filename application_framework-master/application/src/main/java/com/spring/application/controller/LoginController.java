package com.spring.application.controller;

import com.spring.application.repository.RoleRepository;
import com.spring.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/register")
    public String registerGet() {
        return "/register";
    }



}
