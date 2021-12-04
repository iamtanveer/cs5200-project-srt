package com.example.springtemplate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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