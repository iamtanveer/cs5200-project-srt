package com.example.springtemplate.models;


import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Expose
    private Integer id;

    @ManyToOne()
    @JoinColumn(name="article_id")
    private Article article;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    @Expose
    @Lob
    @Column(length=50000)
    private String comment;

    @CreationTimestamp
    private java.sql.Timestamp commentDate;

    public Comment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public java.sql.Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(java.sql.Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Comment(Integer id, Article article, User user, String comment, Timestamp commentDate) {
        this.id = id;
        this.article = article;
        this.user = user;
        this.comment = comment;
        this.commentDate = commentDate;
    }
}