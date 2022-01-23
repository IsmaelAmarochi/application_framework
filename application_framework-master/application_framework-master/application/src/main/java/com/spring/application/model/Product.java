package com.spring.application.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    //Product entity

    //Id is generated automatically
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //Define a many to one relationship between Product and Category
    //Each Product belongs to ONE Category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    private double  price;

    private double weight;

    private String description;

    private String imageName;



}
