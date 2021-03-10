//package com.orangeSoft.market.config;
//
//import com.orangeSoft.market.pojo.UserInfo;
//import com.orangeSoft.market.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class UserDetailServiceImpl implements UserDetailsService {
//    @Autowired
//    UserService userService;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String userTel) throws UsernameNotFoundException {
//        UserInfo userInfo = userService.getUserByTel(userTel);
//        if (userInfo == null) {
//            throw new UsernameNotFoundException("用户不存在");
//        }
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + userInfo.getUserName()));
//
//
//        return new User(
//                userInfo.getUserName(),
//                // 因为数据库是明文，所以这里需加密密码
//                passwordEncoder.encode(userInfo.getUserPassword()),
//                authorities
//        );
//    }
//}
