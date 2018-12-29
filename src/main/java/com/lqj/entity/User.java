package com.lqj.entity;

//import javax.persistence.*;

//@Entity()
//@Table(name = "users")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private int id;
//    @Column(name = "name")
    private String name;
//    @Column(name = "password")
    private String password;
    //todo:设置用户的默认头像
//    @Column(name = "picpath")
    private String picpath;

    public User() {
    }

    public User(int id, String name, String password, String picpath) {
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
