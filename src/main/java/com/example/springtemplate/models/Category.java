package com.example.springtemplate.models;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    public Category() {

    }

    public Category(String category) {
        this.category = category;
    }

    @Id
    @Column(name = "category", nullable = false)
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}