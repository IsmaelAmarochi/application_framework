package com.spring.application.repositories;


import com.spring.application.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}
