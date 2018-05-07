package com.zzw.interfaces.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by yuyidi on 2018/5/7.
 * @desc
 */
public class ExceptionMap {
    public static Map<String, String> exceptionMap = new HashMap();

    static {
        exceptionMap.put(ExceptionConstant.REQUEST_SUCCESS,"服务异常");
    }
}
