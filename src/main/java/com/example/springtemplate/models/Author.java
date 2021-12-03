package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name="author")
public class Author extends User {

    @OneToOne()
    @JsonIgnore
    @Expose
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "interest", nullable = false)
    private Categories interest;

    public Categories getInterest() {
        return interest;
    }

    public void setInterest(Categories interest) {
        this.interest = interest;
    }

    public Author(Categories interest) {
        this.interest = interest;
    }
}
