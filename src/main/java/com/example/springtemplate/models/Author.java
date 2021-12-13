package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="authors")
@PrimaryKeyJoinColumn(name="user_id")
public class Author extends User {

    @ManyToOne
    @JoinColumn(name = "interest", nullable = false)
    private Category interest;

    @OneToMany(mappedBy = "createdUser", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Author(User user, Category interest) {
        super(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.dateOfBirth,
                user.getCreated(), user.getUpdated());
        this.interest = interest;
    }

    public Category getInterest() {
        return interest;
    }

    public void setInterest(Category interest) {
        this.interest = interest;
    }

    public Author(Category category) {
        this.interest = category;
    }

    public Author() { }
}
