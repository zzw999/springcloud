package com.zzw.manage.dao.impl;

import com.zzw.manage.dao.UserDao;
import com.zzw.manage.dao.impl.jpa.UserRepository;
import com.zzw.manage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User retrieve(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<User> page(int page, int limit) {
        return null;
    }

    @Override
    public Page<User> page(Specification<User> specification, Pageable pageable) {
        return null;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public User retrieveByName(String name) {
        return repository.findByName(name);
    }
}
