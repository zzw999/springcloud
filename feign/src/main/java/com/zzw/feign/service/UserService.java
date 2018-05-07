package com.zzw.feign.service;

import com.zzw.feign.service.fallback.UserServiceHystrix;
import com.zzw.interfaces.dto.UserDto;
import com.zzw.interfaces.pojo.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "manage",path = "user", fallback = UserServiceHystrix.class, qualifier = "userService")
public interface UserService {

    @RequestMapping(value = "/name/{name}",method = RequestMethod.GET)
    Response<UserDto> fetchByName(@PathVariable(value = "name") String name);
}
