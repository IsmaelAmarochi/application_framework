package com.spring.application.service;

import com.spring.application.model.Category;
import com.spring.application.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service for all the Category based operations
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    //Get all the available categories
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    //Add a specific category to the DB
    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    //Remove a specific category to the DB
    public void removeCategoryById(int id) { categoryRepository.deleteById(id); }

    //Get a specific category from the DB
    public Optional<Category> getCategoryById(int id) { return categoryRepository.findById(id); }

}

