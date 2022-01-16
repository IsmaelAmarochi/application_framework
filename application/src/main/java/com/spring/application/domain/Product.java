package com.spring.application.domain;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Title field cannot be empty")
    private String title;

    @NotEmpty(message = "Description field cannot empty")
    private String description;

    @NotNull(message = "Price field cannot be empty")
    private Double price;

    @NotNull(message = "PLease choose a category for this product")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    public Product(){
        Category category = new Category();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
