package com.spring.application.repository;

import com.spring.application.model.Category;
import com.spring.application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//Repository for the all the Product based CRUD-Operations
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Get all the products belonging to a specific category defined by its ID
    List<Product> findAllByCategory_Id(int id);

}
