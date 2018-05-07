package com.zzw.feign.service.fallback;

import com.zzw.feign.service.UserService;
import com.zzw.interfaces.dto.UserDto;
import com.zzw.interfaces.pojo.Response;
import org.springframework.stereotype.Component;

/**
 * @author Created by yuyidi on 2018/5/4.
 * @desc
 */
@Component
public class UserServiceHystrix implements UserService {

    @Override
    public Response<UserDto> fetchByName(String name) {
        return null;
    }
}
