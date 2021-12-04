package com.example.springtemplate.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    @Column(name="date_of_birth", columnDefinition = "DATE")
    private String dateOfBirth;

    @CreationTimestamp
    private java.sql.Timestamp created;

    @UpdateTimestamp
    private java.sql.Timestamp updated;

    @OneToMany(mappedBy="to")
    private List<Follow> follows;

    public User() {

    }

    public List<Follow> getFollowing() {
        return following;
    }

    public void setFollowing(List<Follow> following) {
        this.following = following;
    }

    @OneToMany(mappedBy="from")
    private List<Follow> following;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public java.sql.Timestamp getCreated() {
        return created;
    }

    public void setCreated(java.sql.Timestamp created) {
        this.created = created;
    }

    public java.sql.Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(java.sql.Timestamp updated) {
        this.updated = updated;
    }

    public List<Follow> getFollowers() {
        return follows;
    }

    public void setFollowers(List<Follow> follows) {
        this.follows = follows;
    }

    public User(Integer id, String firstName,
                String lastName, String username, String password, String dateOfBirth,
                java.sql.Timestamp created, java.sql.Timestamp updated,
                List<Follow> follows, List<Follow> following) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.created = created;
        this.updated = updated;
        this.follows = follows;
        this.following = following;
    }
}

//@Entity
//@Table(name="users")
//@Inheritance(strategy = InheritanceType.JOINED)
//public class User implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    protected Integer id;
//    protected String firstName;
//    protected String lastName;
//    protected String username;
//    protected String password;
//
//    @Column(name="date_of_birth", columnDefinition = "DATE")
//    protected String dateOfBirth;
//
//    @CreationTimestamp
//    protected java.sql.Timestamp created;
//
//    @UpdateTimestamp
//    protected java.sql.Timestamp updated;
//
//    public User() {
//
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public java.sql.Timestamp getCreated() {
//        return created;
//    }
//
//    public void setCreated(java.sql.Timestamp created) {
//        this.created = created;
//    }
//
//    public java.sql.Timestamp getUpdated() {
//        return updated;
//    }
//
//    public void setUpdated(java.sql.Timestamp updated) {
//        this.updated = updated;
//    }
//
//    public User(Integer id, String firstName, String lastName,
//                String username, String password, String dateOfBirth,
//                java.sql.Timestamp created, java.sql.Timestamp updated) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.password = password;
//        this.dateOfBirth = dateOfBirth;
//        this.created = created;
//        this.updated = updated;
//    }
//}
