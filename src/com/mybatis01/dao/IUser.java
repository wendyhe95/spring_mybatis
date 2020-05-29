package com.mybatis01.dao;

import com.mybatis01.mapper.User;

import java.util.List;

/**
 * Created by wendyhe on 2018/9/13.
 */
public interface IUser {

    //@Select("select * from user where id= #{id}")
    //public User getUserByID(int id);
    public List<User> getUserList();

    public void updateUser(User user);

    public void deleteUser(int userId);

    public User getUser(int id);

    public void insertUser(User user);
}
