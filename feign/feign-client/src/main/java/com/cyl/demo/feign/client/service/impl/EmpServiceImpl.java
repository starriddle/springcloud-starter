package com.cyl.demo.feign.client.service.impl;

import com.cyl.demo.feign.client.entity.Dept;
import com.cyl.demo.feign.client.entity.Emp;
import com.cyl.demo.feign.client.entity.Emp2;
import com.cyl.demo.feign.client.entity.Org;
import com.cyl.demo.feign.client.feign.ServerApi;
import com.cyl.demo.feign.client.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author CYL
 * @date 2018-04-25
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    ServerApi server;

    @Override
    public boolean create(Emp emp) {
        System.out.println("create Emp: " + emp == null?null:emp.toString());

        emp = new Emp(9002, "jack", 27, LocalDate.of(1950,1,1), "shanghai, china", 1,1);
        System.out.println("change create Emp: " + emp == null?null:emp.toString());

        boolean result =  server.create(emp);
        return result;
    }

    @Override
    public boolean update(Emp emp) {
        System.out.println("update Emp: " + emp==null?null:emp.toString());

        emp = new Emp(9002, "jack", 27, LocalDate.of(1950,1,1), "shanghai, china", 1,1);
        System.out.println("change update Emp: " + emp==null?null:emp.toString());

        boolean result =  server.update(emp);
        return result;
    }

    @Override
    public Emp getById(long id) {
        System.out.println("get Emp by Id: " + id);
        Emp emp = server.getById(id);
        System.out.println("return: " + emp.toString());
        return emp;
    }

    @Override
    public Emp2 getEmp2ById(long id) {
        System.out.println("get Emp2 by Id: " + id);
        Emp2 emp2 = server.getEmp2ById(id);
        System.out.println("return: " + emp2.toString());
        return emp2;
    }

    @Override
    public List<Emp> getByDept(Dept dept) {
        System.out.println("get Emp by dept: " + dept==null?null:dept.toString());

        dept = new Dept();
        dept.setId(10);
        System.out.println("change get Emp by dept: " + dept==null?null:dept.toString());

        List<Emp> list = server.getByDept(dept);
        return list;
    }

    @Override
    public List<Emp> getByOrg(Org org) {
        System.out.println("get Emp by org: " + org==null?null:org.toString());

        org = new Org();
        org.setId(100);
        System.out.println("change get Emp by org: " + org==null?null:org.toString());

        List<Emp> list = server.getByOrg(org);
        return list;
    }

    @Override
    public List<Emp> getByDeptAndOrg(Dept dept, Org org) {
        System.out.println("get Emp by dept: " + dept==null?null:dept.toString());
        System.out.println("and org: " + org==null?null:org.toString());

        dept = new Dept();
        dept.setId(10);
        org = new Org();
        org.setId(100);
        System.out.println("change get Emp by dept: " + dept==null?null:dept.toString());
        System.out.println("and org: " + org==null?null:org.toString());

        List<Emp> list = server.getByDeptAndOrg(dept,org);
        return list;
    }

    @Override
    public List<Emp> getByCondition(String name, long age, LocalDate birthday, Dept dept, Org org) {
        System.out.println("get Emp by name=" + name + ", age=" + age);
        System.out.println("and birthday=" + birthday==null?null:birthday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("and dept: " + dept==null?null:dept.toString());
        System.out.println("and org: " + org==null?null:org.toString());

        birthday = LocalDate.of(1950,1,1);
        dept = new Dept();
        dept.setId(10);
        org = new Org();
        org.setId(100);
        System.out.println("and birthday=" + birthday==null?null:birthday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("and dept: " + dept==null?null:dept.toString());
        System.out.println("and org: " + org==null?null:org.toString());

        List<Emp> list = server.getByCondition(name,age,birthday,dept,org);
        return list;
    }
}
