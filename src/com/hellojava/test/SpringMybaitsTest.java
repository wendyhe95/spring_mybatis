package com.hellojava.test;

import com.hellojava.mapper.IUserDao;
import com.hellojava.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by wendyhe on 2018/9/27.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringMybaitsTest {

    @Autowired
    private IUserDao iUserDao;

    @Test
    public void testAdd() {
        User user = new User();
        user.setUsername("new name");
        iUserDao.add(user);
    }

    @Test
    public void testList() {
        System.out.println(iUserDao);
        List<User> users=iUserDao.list();
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }
}
