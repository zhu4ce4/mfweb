package com.lqj.entity;

import org.springframework.stereotype.Component;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import java.io.Serializable;

@Component
//@Entity(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //故意设置默认id为-1
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = -1;
    private String name;
    private String password;
    //todo:设置用户的默认头像
    private String picpath;

    public User() {
    }

    public User(Integer id, String name, String password, String picpath) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.picpath = picpath;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(int id, String name, String picpath) {
        this.id = id;
        this.name = name;
        this.picpath = picpath;
    }

    public User(String name, String password, String picpath) {
        this.name = name;
        this.password = password;
        this.picpath = picpath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", picpath='" + picpath + '\'' +
                '}';
    }
}
