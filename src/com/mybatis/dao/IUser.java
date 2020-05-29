package com.mybatis.dao;

import com.mybatis.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wendyhe on 2018/9/13.
 */
public interface IUser {
    @Select("select * from user where id= #{id}")
    public User getUserByID(int id);

}
