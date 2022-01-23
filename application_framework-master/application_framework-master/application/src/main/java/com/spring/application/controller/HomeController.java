package com.spring.application.controller;

import com.spring.application.global.GlobalData;
import com.spring.application.service.CategoryService;
import com.spring.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    //Controller for all the home related views

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    //Home route, GET
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }

    //Shop route, GET
    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }

    //Sort the shop by category, GET
    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id) {
        //Get all the categories available
        model.addAttribute("categories", categoryService.getAllCategory());
        //Cart count
        model.addAttribute("cartCount", GlobalData.cart.size());
        //Get all the products belonging to a certain category
        model.addAttribute("products", productService.getAllProductsByCategoryId(id));
        return "shop";
    }

    //Show a view of a certain product with its details, GET
    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id) {
        //Get the specific product in order to display the data
        model.addAttribute("product", productService.getProductById(id).get());
        //Cart count
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "viewProduct";
    }

}
