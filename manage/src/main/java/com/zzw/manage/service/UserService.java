package com.zzw.manage.service;

import com.zzw.manage.dao.UserDao;
import com.zzw.manage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Created by zzw on 2018/5/4.
 * @desc
 */
@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public User findById(Long id) {
        return dao.retrieve(id);
    }

    public User findByName(String name) {
        return dao.retrieveByName(name);
    }
}
