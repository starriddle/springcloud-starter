package com.cyl.demo.feign.client.controller;

import com.cyl.demo.feign.client.entity.Dept;
import com.cyl.demo.feign.client.entity.User;
import com.cyl.demo.feign.client.feign.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author CYL
 * @date 2018-04-25
 */
@RestController //可以直接返回String
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserApi server;

    @GetMapping("/create")
    boolean create(@RequestParam(required = false) User user){
        System.out.println("create Emp: " + (user == null?null:user.toString()));
        user = new User(9002, "jack", 27, "1950-01-01", "shanghai, china", 1,1);
        System.out.println("change to create Emp: " + user.toString());

        boolean result =  server.createEmp2(user);
        System.out.println("return: " + result);
        return result;
    }

    @GetMapping("/getById")
    User getById(long id){
        System.out.println("get User by Id: " + id);

        User result = server.getById(id);
        System.out.println("return: " + result);
        return result;
    }

    @GetMapping("/getNameById")
    String getNameById(long id){
        System.out.println("get name by Id: " + id);

        String result = server.getNameById(id);
        System.out.println("return: " + result);
        return result;
    }

    @GetMapping("/getByDept")
    List<User> getByDept(@RequestParam(required = false)Dept dept){
        System.out.println("get Users by Dept: " + dept);
        dept = new Dept(12, "dev", "china", 102);
        System.out.println("change to get Users by Dept: " + dept);

        List<User> result = server.getByDept(dept);
        System.out.println("return: " + result);
        return result;
    }

    @GetMapping("/getNamesByDept")
    List<String> getNamesById(@RequestParam(required = false)Dept dept){
        System.out.println("get names by Dept: " + dept);
        dept = new Dept(12, "dev", "china", 102);
        System.out.println("change to get names by Dept: " + dept);

        List<String> result = server.getNamesByDept(dept);
        System.out.println("return: " + result);
        return result;
    }
}
