package com.zzw.feign.security.handler;

import com.zzw.interfaces.pojo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Created by yuyidi on 2018/5/7.
 * @desc
 */
@Component
public class LoginSuccessHandler extends ResponseHandler implements AuthenticationSuccessHandler {

    Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("登陆验证成功");
        //此处判断是app 还是 pc端web页面  选择是跳转页面还是返回json
        response.setStatus(HttpServletResponse.SC_OK);
        Response<Object> result = new Response<>();
        result.setMessage("登陆成功");
        result.setCode("200");
        response(result,request,response,"/index");
    }
}
