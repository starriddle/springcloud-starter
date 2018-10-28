package com.cyl.demo.hessian.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cyl.demo.hessian.api.entity.User;
import com.cyl.demo.hessian.api.service.UserService;

/**
 * UserService接口的具体实现类
 *
 * @author CYL
 * @date 2018-10-27
 * @see UserService
 */
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    private static final String LOCK = "User";

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public User getById(Integer id) {
        if (id > 0 && id <= users.size()) {
            return users.get(id - 1);
        } else {
            return null;
        }
    }

    @Override
    public Integer create(User user) {
        synchronized (LOCK) {
            user.setId(users.size() + 1);
            users.add(user);
        }
        return user.getId();
    }

    @Override
    public User create(String name, Integer age, String address) {
        User user;
        synchronized (LOCK) {
            user = new User(users.size() + 1, name, age, address);
            users.add(user);
        }
        return user;
    }
}
