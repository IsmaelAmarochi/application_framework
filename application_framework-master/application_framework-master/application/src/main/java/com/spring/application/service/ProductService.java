package com.spring.application.service;

import com.spring.application.model.Product;
import com.spring.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service for all the Product based operations
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    //Get all the products in the DB
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    //Add a specific product to the DB
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    //Remove a specific product to the DB
    public void removeProductById(long id) {
        productRepository.deleteById(id);
    }

    //Get a specific product from the DB defined by an ID
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    //Get all products belonging to a specific category defined by an ID
    public List<Product> getAllProductsByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }


}
