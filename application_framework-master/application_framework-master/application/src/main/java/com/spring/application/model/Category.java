package com.spring.application.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Category {

    //Category entity

    //Id is generated automatically
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;

    private String name;

}
