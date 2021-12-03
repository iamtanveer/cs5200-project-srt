package com.example.springtemplate.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Author extends User {
    private Categories interest;
}
