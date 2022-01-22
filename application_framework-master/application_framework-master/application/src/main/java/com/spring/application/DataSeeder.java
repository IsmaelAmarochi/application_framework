package com.spring.application;

import com.spring.application.model.Category;
import com.spring.application.model.Product;
import com.spring.application.model.Role;
import com.spring.application.model.User;
import com.spring.application.repository.CategoryRepository;
import com.spring.application.repository.RoleRepository;
import com.spring.application.repository.UserRepository;
import com.spring.application.service.ProductService;
import com.spring.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
    private UserRepository userRepository;
    private  ProductService productService;
    private  CategoryRepository categoryRepository;
    private  RoleRepository roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public DataSeeder(UserRepository userRepository, ProductService productService, CategoryRepository categoryRepository,
                      RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void run(String... args) {
//        adminAccount();
//        userAccount();
        categories();
        products();
//        roles();
    }

    List<Role> rolesAdmin = new ArrayList<>();
    List<Role> rolesUser = new ArrayList<>();
    Role adminRole = new Role();
    Role userRole = new Role();
//
    private void adminAccount() {
        User admin = new User();

        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");
        rolesUser.add(userRole);
        admin.setRoles(rolesAdmin);
        admin.setFirstName("Jhon");
        admin.setLastName("Doe");
        userRepository.save(admin);
    }


    private void userAccount() {
        User user = new User();

        user.setEmail("user@gmail.com");
        user.setPassword("user");
        rolesUser.add(adminRole);
        user.setRoles(rolesUser);
        user.setFirstName("Jane");
        user.setLastName("Doe");

        userRepository.save(user);
    }

    Category category1 = new Category();
    Category category2 = new Category();
    Category category3 = new Category();
    Category category4 = new Category();

    private void categories() {

        category1.setName("Fish food");

        category2.setName("Dog food");

        category3.setName("Cat food");

        category4.setName("Monkey food");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);
    }

    private void products() {
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setImageName("dog_food.jpg");
        product1.setPrice(5);
        product1.setWeight(2000);
        product1.setDescription("Dog food with a lot of vitamins and minerals");
        product1.setCategory(category2);
        product2.setName("Dog Food");

        product2.setImageName("cat_food.jpg");
        product2.setPrice(4);
        product2.setWeight(1500);
        product2.setDescription("Cat food with a lot of vitamins and minerals");
        product2.setCategory(category3);
        product2.setName("Cat Food");

        product3.setImageName("fish_food.jpg");
        product3.setPrice(3);
        product3.setWeight(2000);
        product3.setDescription("Fish food with a lot of vitamins and minerals");
        product3.setCategory(category1);
        product3.setName("Fish Food");

        product4.setImageName("monkey_food.jpg");
        product4.setPrice(2);
        product4.setWeight(2000);
        product4.setDescription("Favourite food of all monkeys");
        product4.setCategory(category4);
        product4.setName("Monkey Food");


        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);
        productService.addProduct(product4);
    }

    private void roles() {

        adminRole.setId(1);
        adminRole.setName("ADMIN_ROLE");

        userRole.setId(2);
        userRole.setName("USER_ROLE");

        roleRepository.save(adminRole);
        roleRepository.save(userRole);

    }

}
