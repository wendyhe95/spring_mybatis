package com.hellojava.mapper;

import com.hellojava.pojo.User;

import java.util.List;

/**
 * Created by wendyhe on 2018/9/27.
 */
public interface IUserDao {

    public int add(User user);

    public void delete(User user);

    public User get(int id);

    public int  update(User user);

    public List<User> list();

    public int count();


}
