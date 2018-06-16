package com.cyl.demo.feign.server.controller;

import com.cyl.demo.feign.server.entity.Dept;
import com.cyl.demo.feign.server.entity.User;
import com.cyl.demo.feign.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    User getById(long id){
        return service.getById(id);
    }

    @GetMapping("/getNameById")
    String getNameById(long id){
        return service.getNameById(id);
    }

    @GetMapping("/getByDept")
    List<User> getByDept(Dept dept){
        return service.getByDept(dept);
    }

    @GetMapping("/getNamesByDept")
    List<String> getNamessByDept(Dept dept){
        return service.getNamesByDept(dept);
    }
}
