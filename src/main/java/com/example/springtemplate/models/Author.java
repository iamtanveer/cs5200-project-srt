package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="authors")
@DiscriminatorValue("AUTHOR")
@PrimaryKeyJoinColumn(name="user_id")
public class Author extends User {
    @ManyToOne
    @JoinColumn(name = "interest", nullable = false)
    private Category interest;

    public Author(Integer id, String firstName, String lastName, String username, String password, String dateOfBirth, Timestamp created, Timestamp updated, Category interest) {
        super(id, firstName, lastName, username, password, dateOfBirth, created, updated);
        this.interest = interest;
    }

    public Category getInterest() {
        return interest;
    }

    public void setInterest(Category interest) {
        this.interest = interest;
    }

    public Author() { }
}
