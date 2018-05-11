package com.zzw.feign.security.handler;

import com.zzw.interfaces.pojo.Response;
import org.springframework.http.MediaType;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Created by zzw on 2018/5/7.
 * @desc
 */
public class ResponseHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public void response(Response<Object> result, HttpServletRequest request, HttpServletResponse response, String
            view) {
        if (request.getContentType() != null
                && request.getContentType().indexOf("application/json") > -1) {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
            response.setCharacterEncoding("UTF-8"); //避免乱码
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.print(result);
            writer.flush();
            writer.close();
        } else {
            try {
                request.getSession().setAttribute("message",result.getMessage());
                redirectStrategy.sendRedirect(request, response, view);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
