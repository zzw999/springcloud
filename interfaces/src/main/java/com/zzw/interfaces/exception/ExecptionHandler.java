package com.zzw.interfaces.exception;

import com.zzw.interfaces.pojo.ExceptionInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Created by zzw on 2018/5/7.
 * @desc
 */
@Component
public class ExecptionHandler implements HandlerExceptionResolver {

    Logger logger = LoggerFactory.getLogger(getClass());
    MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
    private List<ExceptionInformation> exceptions = new ArrayList();
    Map<String, String> exceptionMap;

    public ExecptionHandler() {
        this.exceptions.add(new ExceptionInformation(ServiceException.class, HttpServletResponse.SC_OK, "500"));
    }

    {
        exceptionMap = ExceptionMap.exceptionMap;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        ex.printStackTrace();
        ModelAndView mv = new ModelAndView();
        String message = "未知错误";
        String code = "0000";
        String error = "503";

        for (ExceptionInformation exception : exceptions) {
            if (ex.getClass().equals(exception.getException())) {
                logger.info("匹配到异常信息:{}", exception.getException());
                response.setStatus(exception.getHttpStatus());
                code = ex.getMessage();
                message = message(code, ex);
                error = exception.getError();
                break;
            }
        }
        mv.addObject("message", message);
        mv.addObject("code", code);
        mv.addObject("error",error);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8"); // 避免乱码
        mv.setView(jsonView);
        return mv;
    }

    private String message(String type, Exception ex) {
        if (ex instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) ex;
            if (serviceException.getCustomMessage() != null) {
                return serviceException.getCustomMessage();
            }
        }
        String message;
        if (exceptionMap.containsKey(type)) {
            message = exceptionMap.get(type);
        } else {
            message = type;
        }
        return message;
    }
}
