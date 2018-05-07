package com.zzw.interfaces.util;

import org.modelmapper.ModelMapper;

/**
 * @author Created by zzw on 2018/5/4.
 * @desc
 */
public enum BeanCopyUtil {

    INSTANCE;
    private ModelMapper modelMapper;
    BeanCopyUtil() {
        modelMapper = new ModelMapper();
    }
    public ModelMapper getInstance() {
        return modelMapper;
    }

}
