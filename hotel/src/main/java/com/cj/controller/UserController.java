package com.cj.controller;

import com.cj.Service.UserService;
import com.cj.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String userLogin(){
        return  "pages/login";
    }
    @GetMapping("/starter")
    public String starter(){
        return  "pages/starter";
    }

    @GetMapping("/index")
    public String index(){
        return  "pages/index";
    }

   @RequestMapping("/user/login.do")
    @ResponseBody
    public JsonResult login(String username, String password){
   /*    if("".equals(username) || username ==null){
           return "账号为空";
        }
        if("".equals(password) || password ==null){
            return "密码为空";
        }
*/
        System.out.println(username+password);
       // AuthorityUtils.commaSeparatedStringToAuthorityList("user");
        return new JsonResult(1,"成功",null);
    }
    @RequestMapping("/login.do")
    @ResponseBody
    public  User login2(User user){
        System.out.println(user.getUsername()+user.getPassword());
        return user;
    }


}
