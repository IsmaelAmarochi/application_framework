package com.spring.application.repositories;


import com.spring.application.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product,Integer> {

}
