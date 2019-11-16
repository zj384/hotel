package com.cj.ServiceImpl;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("myAuthenctiationFailureHandler")
public class MyAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {



    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        System.out.println("登录失败");
        JSONObject res = new JSONObject();
        try {
            res.put("success",false);
            res.put("msg","登录失败,请检查账号密码是否正确");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.setStatus(500);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(res.toString());
    }
}
