package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;

    @CreationTimestamp
    private java.sql.Timestamp publishedDate;

    @Lob
    @Column(length=100000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @ManyToOne
    @Cascade(value={org.hibernate.annotations.CascadeType.MERGE})
    @JoinColumn(name="created_user")
    private Author createdUser;

    @OneToMany(mappedBy = "article")
    @JsonIgnore
    private List<Comment> comments;

    @Override
    public boolean equals(Object o) {
        if (!( o instanceof Article )) {
            return false;
        }

        Article article = (Article) o;

        return Objects.equals(this.id, article.getId());
    }
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public java.sql.Timestamp getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(java.sql.Timestamp publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Author getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Author createdUser) {
        this.createdUser = createdUser;
    }

    public Article(Author createdUser) {
        this.createdUser = createdUser;
    }

    public Article(Integer id, String title, Timestamp publishedDate, String content, Category category, Author createdUser,
                   List<User> likedUsers) {
        this.id = id;
        this.title = title;
        this.publishedDate = publishedDate;
        this.content = content;
        this.category = category;
        this.createdUser = createdUser;
    }

    public Article() {

    }

    @Override
    public String toString() {
        return title + " " + publishedDate + " " + category + " " + content + " " + createdUser;
    }
}