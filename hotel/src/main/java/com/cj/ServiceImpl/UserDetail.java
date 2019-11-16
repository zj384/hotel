package com.cj.ServiceImpl;

import com.cj.dao.UserDao;
import com.cj.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetail implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // s是传过来的username,根据username查询用户信息
        UserPojo userPojo = new UserPojo();
        userPojo.setUsername(s);
        // 将旧对象覆盖
        userPojo = userDao.findOneUser(userPojo);
        System.out.println(s);
        User user = null;
        if(userPojo.getUsername()==null){
            return null;
        }
        if(userPojo.getStatus() == "0"){
            return null;
        }
        user = new User(
                userPojo.getUsername(),
                userPojo.getPassword(),
                true, // 是否可用
                true, // 账号是否过期
                true, // 密码是否过期
                true, // 账号没有被锁定标志
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_user")
        );
        return user;
    }


}
