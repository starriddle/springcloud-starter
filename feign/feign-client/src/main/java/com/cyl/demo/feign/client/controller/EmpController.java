package com.cyl.demo.feign.client.controller;

import com.cyl.demo.feign.client.entity.Dept;
import com.cyl.demo.feign.client.entity.Emp;
import com.cyl.demo.feign.client.entity.Org;
import com.cyl.demo.feign.client.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author CYL
 * @date 2018-04-25
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService service;

    @GetMapping("/create")
    boolean create(@RequestParam(required = false) Emp emp){
        return service.create(emp);
    }

    @PostMapping("/update")
    Emp update(@RequestParam(required = false) Emp emp){
        return service.update(emp);
    }

    @GetMapping("/getById")
    Emp getById(@RequestParam(required = false) long id){
        return service.getById(id);
    }

    @GetMapping("/getByDept")
    List<Emp> getByDept(@RequestParam(required = false) Dept dept){
        return service.getByDept(dept);
    }

    @GetMapping("/getByOrg")
    List<Emp> getByOrg(@RequestParam(required = false) Org org){
        return service.getByOrg(org);
    }

    @GetMapping("/getByDeptAndOrg")
    List<Emp> getByDeptAndOrg(@RequestParam(required = false) Dept dept, @RequestParam(required = false) Org org){
        return service.getByDeptAndOrg(dept, org);
    }

    @GetMapping("/getByCondition")
    List<Emp> getByCondition(@RequestParam(required = false) String name, @RequestParam(required = false) long age, @RequestParam(required = false) LocalDate birthday, @RequestParam(required = false) Dept dept, @RequestParam(required = false) Org org){
        return service.getByCondition(name,age,birthday,dept,org);
    }
}
