package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
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
    private String publishedDate;
    @Lob
    @Column(length=100000)
    private String content;
    private String category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "LIKES", joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns =  @JoinColumn(name =
                    "ARTICLE_ID"))
    @JsonIgnore
    private Set<User> likedUsers;

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

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<User> getLikedUsers() {
        return likedUsers;
    }

    public void setLikedUsers(Set<User> likedUsers) {
        this.likedUsers = likedUsers;
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

    public void populate(){
        this.getCreatedUser();
        this.getLikedUsers();
        this.getComments();
    }

    public Article(Author createdUser) {
        this.createdUser = createdUser;
    }

    public Article(String title, String publishedDate, String content, String category,
                   Author createdUser) {
        this.title = title;
        this.publishedDate = publishedDate;
        this.category = category;
        this.content = content;
        this.createdUser = createdUser;
    }

    public Article() {

    }

    @Override
    public String toString() {
        return title + " " + publishedDate + " " + category + " " + content + " " + createdUser;
    }
}