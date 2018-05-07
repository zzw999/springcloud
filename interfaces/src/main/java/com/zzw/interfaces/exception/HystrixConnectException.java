package com.zzw.interfaces.exception;

/**
 * @author Created by yuyidi on 2018/5/7.
 * @desc
 */
public class HystrixConnectException extends RuntimeException {

    private String type;
    private String message;

    public HystrixConnectException (String type) {
        super(type);
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
