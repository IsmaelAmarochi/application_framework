package com.spring.application.controller;

import com.spring.application.global.GlobalData;
import com.spring.application.model.Role;
import com.spring.application.model.User;
import com.spring.application.repository.RoleRepository;
import com.spring.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    //Controller for all the login related views

    //BCrypt instance in order to encrypt the incoming passwords
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    //Show the login view, GET
    @GetMapping("/login")
    public String loginGet() {
        GlobalData.cart.clear();
        return "login";
    }

    //Post the form data and check if the user exists in the DB, POST
    //Does not work yet
    @PostMapping("/login")
    public String loginPost(@ModelAttribute("user")User user, HttpServletRequest request) throws ServletException {
        //request.login(user.getEmail(), user.getPassword());
        return "login";
    }

    //Show the register view, GET
    @GetMapping("/register")
    public String registerGet() {
        return "/register";
    }

    //Post the form data from the register, POST
    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user")User user, HttpServletRequest request) throws ServletException {
        //Get the password and ecrypt it using BCrypt
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        //Add the adequate rol to the created user, in this case it is always a "USER_ROLE"
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(2).get());
        user.setRoles(roles);

        userRepository.save(user);
        //Login the user after the creation
        request.login(user.getEmail(), password);
        return "redirect:/";
    }

}
