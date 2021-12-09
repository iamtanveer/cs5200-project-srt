package com.example.springtemplate.models;


import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

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

    private String commentDate;

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

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}