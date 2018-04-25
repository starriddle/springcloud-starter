package com.cyl.demo.feign.server.controller;

import com.cyl.demo.feign.server.entity.Dept;
import com.cyl.demo.feign.server.entity.Emp;
import com.cyl.demo.feign.server.entity.Emp2;
import com.cyl.demo.feign.server.entity.Org;
import com.cyl.demo.feign.server.service.EmpService;
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

    @GetMapping("/index")
    String index(){
        return "Hello Emp —— Feign Server";
    }

    @PostMapping("/create")
    boolean create(Emp emp){
        boolean ret = service.create(emp);
        System.out.println("return: " + ret);
        return ret;
    }
    @PostMapping("/update")
    boolean update(Emp emp){
        return service.update(emp);
    }

    @GetMapping("/getById")
    Emp getById(long id){
        Emp ret = service.getById(id);
        System.out.println("return: " + ret.toString());
        return ret;
    }

    @GetMapping("/getEmp2ById")
    Emp2 getEmp2ById(long id){
        Emp2 emp2 = service.getEmp2ById(id);
        System.out.println("return: " + emp2.toString());
        return emp2;
    }

    @GetMapping("/getByDept")
    List<Emp> getByDept(Dept dept){
        return service.getByDept(dept);
    }

    @GetMapping("/getByOrg")
    List<Emp> getByOrg(Org org){
        return service.getByOrg(org);
    }

    @GetMapping("/getByDeptAndOrg")
    List<Emp> getByDeptAndOrg(Dept dept, Org org){
        return service.getByDeptAndOrg(dept, org);
    }

    @GetMapping("/getByCondition")
    List<Emp> getByCondition(String name, long age, @RequestParam(required = false) LocalDate birthday, @RequestParam(required = false) Dept dept, @RequestParam(required = false) Org org){
        return service.getByCondition(name,age,birthday,dept,org);
    }
}
