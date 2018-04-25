package com.cyl.demo.feign.server.service;

import com.cyl.demo.feign.server.entity.Dept;
import com.cyl.demo.feign.server.entity.Emp;
import com.cyl.demo.feign.server.entity.Emp2;
import com.cyl.demo.feign.server.entity.Org;

import java.time.LocalDate;
import java.util.List;

/**
 * @author CYL
 * @date 2018-04-25
 */
public interface EmpService {

    boolean create(Emp emp);
    boolean update(Emp emp);
    Emp getById(long id);
    Emp2 getEmp2ById(long id);
    List<Emp> getByDept(Dept dept);
    List<Emp> getByOrg(Org org);
    List<Emp> getByDeptAndOrg(Dept dept, Org org);
    List<Emp> getByCondition(String name, long age, LocalDate birthday, Dept dept, Org org);

}