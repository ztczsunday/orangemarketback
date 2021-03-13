package com.orangeSoft.market.config;

import com.google.gson.Gson;
import com.orangeSoft.market.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailService;

    //指定加密方式
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().formLogin().loginPage("/login")
                .successHandler((request, response, authentication) -> {
                    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    if (principal instanceof UserInfo) {
                        UserInfo user = (UserInfo) principal;
                        System.out.println("currUser:" + user.getUsername());
                        System.out.println("userPWD:" + user.getPassword());
                        System.out.println();
                        //维护在session中
                        request.getSession().setAttribute("userDetail", user);
                        response.sendRedirect(request.getRequestURI());
                    }
                })
                .failureHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
                    out.flush();
                    out.close();
                })
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and().rememberMe().tokenValiditySeconds(60 * 60 * 24 * 7)
                .and().csrf().disable().cors();
    }
}
