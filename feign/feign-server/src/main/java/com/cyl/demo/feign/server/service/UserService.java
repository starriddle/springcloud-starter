package com.cyl.demo.feign.server.service;

import com.cyl.demo.feign.server.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author CYL
 * @date 2018-04-25
 */
@Service
public class UserService {

    public boolean create(User user) {
        System.out.println("create Emp: " + (user==null?null:user.toString()));
        System.out.println("return: " + true);
        return true;
    }

    public User getById(long id) {
        System.out.println("get User by Id: " + id);
        User user = new User(9001, "jack", 27, "1952-02-02", "shanghai, china", 2,2);
        System.out.println("return: " + user);
        return user;
    }

}
