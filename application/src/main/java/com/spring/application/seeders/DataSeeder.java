package com.spring.application.seeders;

import com.spring.application.domain.Category;
import com.spring.application.domain.Product;
import com.spring.application.repositories.CategoryRepository;
import com.spring.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() == 0){
            category();
            exampleProducts();
        }
    }

    Category category1 = new Category();
    Category category2 = new Category();
    Category category3 = new Category();
    Category category4 = new Category();
    Category category5 = new Category();
    Category category6 = new Category();

    private void category(){

        category1.setId(1);
        category1.setType("Habitat");
        category2.setId(2);
        category2.setType("Food");
        category3.setId(3);
        category3.setType("Toys");


        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);


    }

    private void exampleProducts(){
        final String NAME = "Example Name";
        final String NAME_FOR_HAB_DOG = "Habitat for Willy the dog";
        final String NAME_FOR_TOYS_DOG = "Toy for Willy the dog";
        final String NAME_FOR_FOOD_DOG = "Food for Willy the dog";

        final String NAME_FOR_HAB_CAT = "Habitat for Purri the cat";
        final String NAME_FOR_TOYS_CAT = "Toy for animal Purri the cat";
        final String NAME_FOR_FOOD_CAT = "Food for Purri the cat";

        String im = "http://localhost:8081/dog_food.jpeg";
        System.out.println(im);


        final String IMAGE_URL_FOR_HAB_DOG = "";
        final String IMAGE_URL_FOR_TOYS_DOG = Base64.getEncoder().encodeToString(im.getBytes(StandardCharsets.UTF_8));
        System.out.println(IMAGE_URL_FOR_TOYS_DOG);

        final String IMAGE_URL_FOR_FOOD_DOG = "http://localhost:8081/dog_food.jpeg";
        System.out.println(new String(Base64.getEncoder().encodeToString(IMAGE_URL_FOR_FOOD_DOG.getBytes())));

        final String IMAGE_URL_FOR_FOOD_CAT = "";
        final String IMAGE_URL_FOR_TOYS_CAT = "";
        final String IMAGE_URL_FOR_HAB_CAT = "";


        final String IMAGE_URL = "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX7389458.jpg";
        final String DESCRIPTION = "Example Description";

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        Product product6 = new Product();
        Product product7 = new Product();
        Product product8 = new Product();
        Product product9 = new Product();
        Product product10 = new Product();



//        //DOG
//        product1.setTitle(NAME);
//        product1.setImage(IMAGE_URL);
//        product1.setDescription(DESCRIPTION);
//        product1.setCategory(category1);
//        product1.setPrice(19.22);

        //DOG - TOYS
        product2.setTitle(NAME);
        product2.setImage(new String(Base64.getEncoder().encodeToString(IMAGE_URL_FOR_FOOD_DOG.getBytes())));
        product2.setDescription(NAME_FOR_FOOD_DOG);
        product2.setCategory(category2);
        product2.setPrice(19.33);

        //DOG - FOOD
        product3.setTitle(NAME_FOR_FOOD_DOG);
        product3.setImage(IMAGE_URL_FOR_TOYS_DOG);
        product3.setDescription(NAME_FOR_FOOD_DOG);
        product3.setCategory(category1);
        product3.setPrice(19.33);

        //DOG - HAB
        product4.setTitle(NAME);
        product4.setImage(IMAGE_URL);
        product4.setDescription(DESCRIPTION);
        product4.setCategory(category2);
        product4.setPrice(19.33);

        //CAT - HAB
        product5.setTitle(NAME);
        product5.setImage(IMAGE_URL);
        product5.setDescription(DESCRIPTION);
        product5.setCategory(category2);
        product5.setPrice(19.33);

        //CAT - FOOD
        product6.setTitle(NAME);
        product6.setImage(IMAGE_URL);
        product6.setDescription(DESCRIPTION);
        product6.setCategory(category2);
        product6.setPrice(19.33);

        //CAT - TOYS
        product7.setTitle(NAME);
        product7.setImage(IMAGE_URL);
        product7.setDescription(DESCRIPTION);
        product7.setCategory(category2);
        product7.setPrice(19.33);
//
//        //CAT
//        product8.setTitle(NAME);
//        product8.setImage(IMAGE_URL);
//        product8.setDescription(DESCRIPTION);
//        product8.setCategory(category2);
//        product8.setPrice(19.33);

//        //
//        product9.setTitle(NAME);
//        product9.setImage(IMAGE_URL);
//        product9.setDescription(DESCRIPTION);
//        product9.setCategory(category2);
//        product9.setPrice(19.33);
//
//        //
//        product10.setTitle(NAME);
//        product10.setImage(IMAGE_URL);
//        product10.setDescription(DESCRIPTION);
//        product10.setCategory(category2);
//        product10.setPrice(19.33);



//        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
//        productRepository.save(product8);


    }

}
