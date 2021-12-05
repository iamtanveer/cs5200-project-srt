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
    @OneToOne()
    @JsonIgnore
    @Expose
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "interest", nullable = false)
    private Categories interest;

    public Author(Integer id, String firstName, String lastName, String username, String password, String dateOfBirth, Timestamp created, Timestamp updated, Categories interest) {
        super(id, firstName, lastName, username, password, dateOfBirth, created, updated);
        this.interest = interest;
    }

    public Categories getInterest() {
        return interest;
    }

    public void setInterest(Categories interest) {
        this.interest = interest;
    }

    public Author() { }
}
