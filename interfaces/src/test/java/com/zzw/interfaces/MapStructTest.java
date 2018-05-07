package com.zzw.interfaces;

import com.zzw.interfaces.dto.UserDto;
import com.zzw.interfaces.util.BeanCopyUtil;
import com.zzw.interfaces.util.JacksonUtil;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by yuyidi on 2018/5/4.
 * @desc
 */
public class MapStructTest {


    Logger logger = LoggerFactory.getLogger(MapStructTest.class);
    @Test
    public void model() {
//        long start = System.currentTimeMillis();
        User user = new User();
        user.setId(1L);
        user.setName("123");
        user.setPassword("123");
        Role role = new Role();
        role.setId(1L);
        role.setCode("123");
        role.setName("123");
        user.setRole(role);
//        List<User> users = new ArrayList();
//        users.add(user);
//        users.add(user);
//        users.add(user);
//        users.add(user);
//        users.add(user);
//        users.add(user);
//        List<UserDto> userDTOS = BeanCopyUtil.INSTANCE.getInstance().map(users,new TypeToken<List<UserDto>>() {}.getType());
//
//        System.out.println(userDTOS.toString());
//        for (int i=0;i<1000000;i++) {
            ModelMapper modelMapper = BeanCopyUtil.INSTANCE.getInstance();
//            User user = new User();
//            user.setId(1L);
//            user.setName("123");
//            user.setPassword("123");
//            Role role = new Role();
//            role.setId(1L);
//            role.setCode("123");
//            role.setName("123");
//            user.setRole(role);
            UserDto map = modelMapper.map(user, UserDto.class);
        String encode = JacksonUtil.encode(map);
        logger.info("结果:{}", encode);
            System.out.println(map.toString());
            System.out.println(user.toString());
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);
    }

    @Test
    public void teset() {
        logger.info("结果:{}", BeanCopyUtil.INSTANCE.getInstance()==BeanCopyUtil.INSTANCE.getInstance());
    }
}
