package com.example.springboot.entity;

import javax.persistence.*;


@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;         //主键ID

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

//    @Column(name="date")
//    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
}
