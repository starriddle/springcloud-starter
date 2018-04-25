package com.cyl.demo.feign.server.service.impl;

import com.cyl.demo.feign.server.entity.Dept;
import com.cyl.demo.feign.server.entity.Emp;
import com.cyl.demo.feign.server.entity.Emp2;
import com.cyl.demo.feign.server.entity.Org;
import com.cyl.demo.feign.server.service.EmpService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CYL
 * @date 2018-04-25
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Override
    public boolean create(Emp emp) {
        System.out.println("update Emp: " + emp==null?null:emp.toString());
        return true;
    }

    @Override
    public boolean update(Emp emp) {
        System.out.println("update Emp: " + emp==null?null:emp.toString());
        return true;
    }

    @Override
    public Emp getById(long id) {
        System.out.println("get Emp by Id: " + id);
        Emp emp = new Emp(9001, "jack", 27, LocalDate.of(1950,1,1), "shanghai, china", 1,1);
        return emp;
    }

    @Override
    public Emp2 getEmp2ById(long id) {
        System.out.println("get Emp2 by Id: " + id);
        Emp2 emp2 = new Emp2(9001, "jack", 27, "1952-02-02", "shanghai, china", 2,2);
        return emp2;
    }

    @Override
    public List<Emp> getByDept(Dept dept) {
        System.out.println("and dept: " + dept==null?null:dept.toString());
        Emp emp = new Emp(9001, "jack", 27, LocalDate.of(1950,1,1), "shanghai, china", 1,1);
        List<Emp> list = new ArrayList<>();
        list.add(emp);
        return list;
    }

    @Override
    public List<Emp> getByOrg(Org org) {
        System.out.println("and org: " + org==null?null:org.toString());
        Emp emp = new Emp(9001, "jack", 27, LocalDate.of(1950,1,1), "shanghai, china", 1,1);
        List<Emp> list = new ArrayList<>();
        list.add(emp);
        return list;
    }

    @Override
    public List<Emp> getByDeptAndOrg(Dept dept, Org org) {
        System.out.println("and dept: " + dept==null?null:dept.toString());
        System.out.println("and org: " + org==null?null:org.toString());

        Emp emp = new Emp(9001, "jack", 27, LocalDate.of(1950,1,1), "shanghai, china", 1,1);
        List<Emp> list = new ArrayList<>();
        list.add(emp);
        return list;
    }

    @Override
    public List<Emp> getByCondition(String name, long age, LocalDate birthday, Dept dept, Org org) {
        System.out.println("get Emp by name=" + name + ", age=" + age);
        System.out.println("and birthday=" + birthday==null?null:birthday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("and dept: " + dept==null?null:dept.toString());
        System.out.println("and org: " + org==null?null:org.toString());

        Emp emp = new Emp(9001, "jack", 27, LocalDate.of(1950,1,1), "shanghai, china", 1,1);
        List<Emp> list = new ArrayList<>();
        list.add(emp);
        return list;
    }
}
