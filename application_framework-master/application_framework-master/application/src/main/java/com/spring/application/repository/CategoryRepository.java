package com.spring.application.repository;

import com.spring.application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
//Repository for the all the Category based CRUD-Operations
public interface CategoryRepository extends JpaRepository<Category, Integer> {}
