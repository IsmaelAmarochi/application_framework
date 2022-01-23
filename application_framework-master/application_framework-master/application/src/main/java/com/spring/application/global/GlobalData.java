package com.spring.application.global;

import com.spring.application.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    //Global data variable, used for the cart
    //Using this variable, we can easily access the elements in the cart

    public  static List<Product> cart;

    static {
        cart = new ArrayList<Product>();
    }

}
