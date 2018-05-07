package com.zzw.feign.controller;

import com.zzw.feign.business.UserBusiness;
import com.zzw.interfaces.dto.UserDto;
import com.zzw.interfaces.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private UserBusiness business;

    @Value("${value}")
    private String value;

    @RequestMapping(value = "/name/{name}",method = RequestMethod.GET)
    public Response<UserDto> fetchByName(@PathVariable String name){
        UserDto response = business.findByName(name);
        return new Response<>(response);
    }

}
