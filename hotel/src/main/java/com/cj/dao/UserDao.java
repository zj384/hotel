package com.cj.dao;

import com.cj.pojo.UserPojo;

import java.util.List;

public interface UserDao {
    /*通用查询*/
     UserPojo findOneUser(UserPojo userPojo);
    /*新增用户*/
     Integer addUser(UserPojo userPojo);
    /*修改用户*/
     Integer updateUser(UserPojo userPojo);

}
