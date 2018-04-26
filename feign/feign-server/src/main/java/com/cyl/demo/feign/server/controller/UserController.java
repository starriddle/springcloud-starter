package com.cyl.demo.feign.server.controller;

import com.cyl.demo.feign.server.entity.User;
import com.cyl.demo.feign.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * @author CYL
 * @date 2018-04-25
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    boolean create(@RequestBody User user){
        return service.create(user);
    }

    @GetMapping("/getById")
    User getEmp2ById(long id){
        User user = service.getById(id);
        System.out.println("return: " + user.toString());
        return user;
    }
}
