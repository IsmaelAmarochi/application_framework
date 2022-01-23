package com.spring.application.controller;

import com.spring.application.global.GlobalData;
import com.spring.application.model.Product;
import com.spring.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    //Controller for all the cart related views

    @Autowired
    ProductService productService;

    //Add products to cart, GET route
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id) {
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }


    @GetMapping("/cart")
    public String cartGet(Model model) {
        //Total of elements in the cart
        model.addAttribute("cartCount", GlobalData.cart.size());
        //Total sum of the elements in the cart
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    //Delete products from cart, GET route
    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index) {
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    //Go to checkout view
    @GetMapping("/checkout")
    public String checkout(Model model) {
        //Total sum of the elements in the cart
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }

    //Go to success view when order is placed
    @PostMapping("/orderPlaced")
    public String orderPlaced() {
        //Cart is cleared since the user placed the order
        GlobalData.cart.clear();
        return "orderPlaced";
    }

}


