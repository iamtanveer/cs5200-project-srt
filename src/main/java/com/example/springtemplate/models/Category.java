package com.example.springtemplate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="categories")
//public class Category {
//
//    @Id
//    private Categories category;
//
//    public Category(Categories category) {
//        this.category = category;
//    }
//
//    public Category (){}
//
//    public Categories getCategory() {
//        return category;
//    }
//
//    public void setCategory(Categories category) {
//        this.category = category;
//    }
//}

@Entity
enum Categories {
    SPORTS, ENTERTAINMENT, EDUCATION, POLITICS;
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