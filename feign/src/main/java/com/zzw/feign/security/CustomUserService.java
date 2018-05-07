package com.zzw.feign.security;

import com.zzw.feign.business.UserBusiness;
import com.zzw.interfaces.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author Created by zzw on 2018/5/4.
 * @desc
 */
@Component
public class CustomUserService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserBusiness business;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDto userDto = business.findByName(s);

        logger.info("用户名：{},密码：{}",userDto.getName(),userDto.getPassword());

        CustomUserDetails customUserDetails = new CustomUserDetails(userDto.getId(),userDto.getName(),userDto.getPassword(),new ArrayList<>());

        return customUserDetails;
    }
}
