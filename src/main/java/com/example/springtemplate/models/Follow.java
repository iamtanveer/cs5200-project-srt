package com.example.springtemplate.models;

import javax.persistence.*;

@Entity
@Table(name = "follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    @ManyToOne
    @JoinColumn(name="from_user")
    private User from;

    @ManyToOne
    @JoinColumn(name="to_user")
    private User to;

    public Follow() {}

    public Follow(User from, User to) {
        this.from = from;
        this.to = to;
    }
}