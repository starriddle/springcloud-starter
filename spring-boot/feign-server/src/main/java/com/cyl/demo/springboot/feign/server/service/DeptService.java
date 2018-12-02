package com.cyl.demo.springboot.feign.server.service;

import com.cyl.demo.springboot.feign.server.entity.Dept;
import com.cyl.demo.springboot.feign.server.entity.Org;

import java.time.LocalDate;
import java.util.List;

/**
 * @author CYL
 * @date 2018-04-25
 */
public interface DeptService {

    boolean create(Dept dept);
    boolean update(Dept dept);
    Dept getById(long id);
    List<Dept> getByOrgId(long orgId);
    List<Dept> getByOrg(Org org);
    Dept getByCondition(String name, String address, LocalDate foundDay, Org org);

}
