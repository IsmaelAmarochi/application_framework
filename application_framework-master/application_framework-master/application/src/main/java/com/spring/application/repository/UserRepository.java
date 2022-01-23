package com.spring.application.repository;

import com.spring.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//Repository for the all the User based CRUD-Operations
public interface UserRepository extends JpaRepository<User, Integer> {

    //Get a specific user defined by his/her email
    Optional<User> findUserByEmail(String email);

}
