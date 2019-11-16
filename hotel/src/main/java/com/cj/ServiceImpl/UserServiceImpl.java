package com.cj.ServiceImpl;

import com.cj.Service.UserService;
import com.cj.dao.UserDao;
import com.cj.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public UserPojo findUOneUser(UserPojo  userPojo) {
        return userDao.findOneUser(userPojo);
    }
}
