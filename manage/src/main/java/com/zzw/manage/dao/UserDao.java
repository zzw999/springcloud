package com.zzw.manage.dao;

import com.zzw.manage.entity.User;

/**
 * @author Created by zzw on 2018/5/4.
 * @desc
 */
public interface UserDao extends BaseDao<User,Long> {

    User retrieveByName(String name);

}
