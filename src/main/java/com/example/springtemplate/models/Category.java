package com.example.springtemplate.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {

    @Id
    private Categories category;

    public Category(Categories category) {
        this.category = category;
    }

    public Category (){}

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}

enum Categories {
    SPORTS, ENTERTAINMENT, EDUCATION, POLITICS;
}