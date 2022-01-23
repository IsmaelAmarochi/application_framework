package com.spring.application.repository;

import com.spring.application.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
//Repository for the all the Role based CRUD-Operations
public interface RoleRepository extends JpaRepository<Role, Integer> {}
