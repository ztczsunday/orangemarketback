package com.orangeSoft.market.common.config.security;

import com.google.gson.Gson;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private Gson gson;
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

    @Override
    public void configure(WebSecurity web) throws Exception {
        //配置静态文件不需要认证
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/index.html");
        web.ignoring().antMatchers("/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/AlipayReturn").permitAll()
                .antMatchers("/register").permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin().loginPage("/index.html").loginProcessingUrl("/login")
                .successHandler((request, response, authentication) -> {
                    //获取Principal，以用于维护session
                    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    if (principal instanceof UserInfo) {
                        UserInfo user = (UserInfo) principal;
                        //维护在session中
                        request.getSession().setAttribute("userDetail", user);

                        //登录成功，返回信息
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.print(gson.toJson(Result.success(MySessionUtil.getCurrUser(), "登录成功")));
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler((request, response, authentication) -> {
                    //登录失败，返回信息
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.print(gson.toJson(Result.fail(null, "登录失败")));
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
