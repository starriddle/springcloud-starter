package com.cyl.demo.feign.server.service;

import com.cyl.demo.feign.server.entity.Org;

import java.time.LocalDate;

/**
 * @author CYL
 * @date 2018-04-25
 */
public interface OrgService {

    boolean create(Org org);

    boolean update(Org org);

    Org getById(long id);

    Org getByCondition(String name, String address, LocalDate foundDay);
}
