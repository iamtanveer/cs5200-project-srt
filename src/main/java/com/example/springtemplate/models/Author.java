package com.example.springtemplate.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class Author extends User {

    private Category interest;

}
