package com.cyl.demo.feign.client.controller;

import com.cyl.demo.feign.client.entity.User;
import com.cyl.demo.feign.client.feign.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CYL
 * @date 2018-04-25
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserApi server;

    @GetMapping("/create")
    boolean create(@RequestParam(required = false) User user){
        System.out.println("create Emp: " + (user == null?null:user.toString()));
        user = new User(9002, "jack", 27, "1950-01-01", "shanghai, china", 1,1);
        System.out.println("change create Emp: " + user.toString());

        boolean result =  server.createEmp2(user);
        System.out.println("return: " + result);
        return result;
    }

    @GetMapping("/getById")
    User getEmp2ById(long id){
        System.out.println("get Emp2 by Id: " + id);

        User user = server.getById(id);
        System.out.println("return: " + user);
        return user;
    }
}
