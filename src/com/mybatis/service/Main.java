package com.mybatis.service;

import com.mybatis.dao.IUser;
import com.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by wendyhe on 2018/9/13.
 */
public class Main {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader = Resources.getResourceAsReader("config/configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            sqlSessionFactory.getConfiguration().addMapper(IUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }


    public static void main(String[] args) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            IUser iuser = sqlSession.getMapper(IUser.class);
            User user = iuser.getUserByID(1);
            System.out.println("name："+user.getUsername());
            System.out.println("password："+user.getPassword());
            System.out.println("phone："+user.getPhone());
        } finally {
            sqlSession.close();
        }
    }
}
