package com.orangeSoft.market.config;

import com.orangeSoft.market.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * spring security自定义配置
 */
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
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login").successHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (principal instanceof UserInfo) {
                    UserInfo user = (UserInfo) principal;
                    System.out.println("currUser:" + user.getUsername());
                    System.out.println("userPWD:" + user.getPassword());
                    System.out.println(user.toString());
                    //维护在session中
                    request.getSession().setAttribute("userDetail", user);
                    response.sendRedirect("/loginSuccess");
                }
            }
        })
                .failureForwardUrl("/loginFailure")
                .usernameParameter("name").passwordParameter("passwd")
                .permitAll()
                .and().logout().logoutSuccessUrl("/login")
                .and().rememberMe().tokenValiditySeconds(60 * 60 * 24 * 7)
                .and().csrf().disable();
    }
}
