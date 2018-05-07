package com.zzw.feign.business;

import com.zzw.feign.service.UserService;
import com.zzw.interfaces.dto.UserDto;
import com.zzw.interfaces.exception.ExceptionConstant;
import com.zzw.interfaces.exception.HystrixConnectException;
import com.zzw.interfaces.exception.ServiceException;
import com.zzw.interfaces.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Created by zzw on 2018/5/7.
 * @desc
 */
@Service
public class UserBusiness {

    @Autowired
    @Qualifier("userService")
    private UserService manageService;

    public UserDto findByName(String name) {
        Response<UserDto> response = manageService.fetchByName(name);
        String code = response.getCode();
        if(ExceptionConstant.REQUEST_SUCCESS.equals(code)) {
            return response.getResult();
        }else if(ExceptionConstant.HYSTRIX_CONNECT_EXCEPTION.equals(code)) {
            throw new HystrixConnectException(code);
        }
        throw new ServiceException(code);
    }

}
