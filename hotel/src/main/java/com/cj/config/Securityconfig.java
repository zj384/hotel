package com.cj.config;

import com.cj.ServiceImpl.MyAuthenctiationFailureHandler;
import com.cj.ServiceImpl.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetail userDetail;
    @Autowired
    MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**","/js/**","/image/**","/bower_components/**","/build/**","/dist/**","/plugins/**","/login","/user/login.do","/index").permitAll()
              //  .anyRequest().authenticated()
            .and().formLogin().loginPage("/login").loginProcessingUrl("/login.do").failureUrl("/index")
                .defaultSuccessUrl("/starter").and().csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      //  auth.userDetailsService(userDetail);

      /*  auth.inMemoryAuthentication()
                .withUser("user")
                .password("{1}")
                .roles("user");*/
        auth.inMemoryAuthentication().passwordEncoder
                (new BCryptPasswordEncoder()).withUser("admin").password(
                        new BCryptPasswordEncoder().encode("1")).roles("user");
    }
}
