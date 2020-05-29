package com.mybatis02.test;

import com.mybatis02.mapper.Post;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by wendyhe on 2018/9/17.
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


//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        SqlSession sqlsession = sqlSessionFactory.openSession();
//        try {
//            int userid = 1;
//            User user = sqlsession.selectOne("com.mybatis.mapper.getUser", userid);
//            System.out.println("username: "+user.getUsername());
//            List<Post> posts = user.getPosts();
//            for(Post p : posts) {
//                System.out.println("Title:" + p.getTitle());
//                System.out.println("Content:" + p.getContent());
//            }
//        } finally {
//            sqlsession.close();
//        }
//    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //通过工厂得到Sqlsession实例
        SqlSession sqlsession = sqlSessionFactory.openSession();
        try {
            //int postId = 1;
            //selectOne(statement,parameter)
            //第一个参数：映射文件中statement的id，等于namespace + "." + statement的id
            //第二个参数：指定和映射文件中所匹配的parameterType类型的参数

            Post post = sqlsession.selectOne("com.mybatis.mapper.getPosts", 1);
            System.out.println("title: "+post.getTitle());
            System.out.println("userName: "+post.getUser().getUsername());
        } finally {
            sqlsession.close();
        }
    }
}
