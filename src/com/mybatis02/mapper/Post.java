package com.mybatis02.mapper;

/**
 * Created by wendyhe on 2018/9/17.
 */
public class Post {
    private int id;
    private User user;
    private String title;
    private String content;
    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
