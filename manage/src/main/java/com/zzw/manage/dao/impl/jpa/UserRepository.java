package com.zzw.manage.dao.impl.jpa;

import com.zzw.manage.entity.User;

/**
 * @author Created by yuyidi on 2018/5/4.
 * @desc
 */
public interface UserRepository extends CustomJpaRepository<User, Long> {

    User findByName(String name);

}
