package com.lqj.entity;

import org.springframework.stereotype.Service;

@Service("taolun")
public class TaoLun {
    private int id;
    private String title;
    private String author;
    private String message;

    public TaoLun() {
    }

    public TaoLun(String title, String author, String message) {
        this.title = title;
        this.author = author;
        this.message = message;
    }

    public TaoLun(int id, String title, String message, String author) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TaoLun{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
