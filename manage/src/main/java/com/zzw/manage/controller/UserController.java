package com.zzw.manage.controller;

import com.zzw.interfaces.dto.UserDto;
import com.zzw.interfaces.exception.ServiceException;
import com.zzw.interfaces.pojo.Response;
import com.zzw.interfaces.util.BeanCopyUtil;
import com.zzw.manage.entity.User;
import com.zzw.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by yuyidi on 2018/5/4.
 * @desc
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Response<UserDto> fetchById(@PathVariable Long id) {
        User result = service.findById(id);
        UserDto response = BeanCopyUtil.INSTANCE.getInstance().map(result, UserDto.class);
        return new Response<>(response);
    }

    @RequestMapping(value = "/name/{name}",method = RequestMethod.GET)
    public Response<UserDto> fetchByName(@PathVariable String name) {
        User result = service.findByName(name);
        UserDto response = BeanCopyUtil.INSTANCE.getInstance().map(result, UserDto.class);
        return new Response<>(response);
    }
}
