package com.mybatis01.test;

import com.mybatis01.dao.IUser;
import com.mybatis01.mapper.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by wendyhe on 2018/9/13.
 */
public class Test {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            //读取Configuration.xml文件
            reader = Resources.getResourceAsReader("config/Configuration.xml");
            //初始化mybatis,创建SqlSessionFactory类的实例
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //创建session实例
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 获取用户数据列表
            testGetUserList();

            // 更新数据
            // testUpdate();

            // 删除数据
            // testDelete();

            // 插入数据
            // testInsert();

        } finally {
            session.close();
        }
    }

    /**
     * 获取用户列表
     */
    public static void testGetUserList() {
        try {
            SqlSession sqlsession = sqlSessionFactory.openSession();
            //创建IUser对象 mybatis自动生成mapper代理对象
            IUser iuser = sqlsession.getMapper(IUser.class);
            // 显示User信息
            System.out.println("Test Get start...");
            System.out.println(iuser.getUserList());
            System.out.println("Test Get finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新数据
     */
    public static void testUpdate() {
        try {
            SqlSession sqlsession = sqlSessionFactory.openSession();
            IUser iuser = sqlsession.getMapper(IUser.class);
            System.out.println("Test update start...");
            // 执行更新
            User user = iuser.getUser(1);
            user.setUsername("admin");
            iuser.updateUser(user);
            // 提交事务
            sqlsession.commit();
            // 显示更新之后User信息
            System.out.println("After update");
            System.out.println(iuser.getUser(1));
            System.out.println("Test update finished...");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *删除数据
     */
    public static void testDelete() {
        try {
            SqlSession sqlsession = sqlSessionFactory.openSession();
            IUser iuser = sqlsession.getMapper(IUser.class);
            System.out.println("Test delete start...");
            // 显示删除之前User信息
            System.out.println("Before delete");
            System.out.println(iuser.getUserList());
            // 执行删除
            iuser.deleteUser(2);
            // 提交事务
            sqlsession.commit();
            // 显示删除之后User信息
            System.out.println("After delete");
            System.out.println(iuser.getUserList());
            System.out.println("Test delete finished...");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入数据
     */
    public static void testInsert() {
        try {
            // 获取Session连接
            SqlSession sqlsession = sqlSessionFactory.openSession();
            // 获取Mapper
            IUser iuser = sqlsession.getMapper(IUser.class);
            System.out.println("Test insert start...");
            // 执行插入
            User user = new User();
            user.setId(0);
            user.setUsername("Google");
            user.setPassword("d444");
            user.setPhone("13647582738");
            iuser.insertUser(user);
            // 提交事务
            sqlsession.commit();
            // 显示插入之后User信息
            System.out.println("After insert");
            System.out.println(iuser.getUserList());
            System.out.println("Test insert finished...");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
