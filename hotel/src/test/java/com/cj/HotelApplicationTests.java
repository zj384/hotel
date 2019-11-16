package com.cj;

import com.cj.dao.UserDao;
import com.cj.pojo.UserPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class HotelApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    DataSource dataSource;

    /*测试连接*/
    @Test
    void testDs() throws SQLException {
        System.out.println( dataSource.getConnection());

    }
    /*测试用户*/
    @Autowired
    UserDao userDao;
    @Test
    void testUser() {
        UserPojo userPojo = new UserPojo();
        userPojo.setId(1);
        System.out.println(userDao.findOneUser(userPojo));
    }


}
