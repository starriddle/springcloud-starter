package com.cyl.demo.hessian.server.service;

import com.cyl.demo.hessian.server.entity.School;

/**
 * School Service
 *
 * @author CYL
 * @date 2018-10-27
 */
public interface SchoolService {

    /**
     * 统计 School 数量
     *
     * @return total number of schools
     */
    Integer count();

    /**
     * 根据id获取对象
     * @param id school id
     * @return school with the id
     */
    School getById(Integer id);

    /**
     * 根据传入的对象创建School并返回对象
     *
     * @param school school need to be created
     * @return school currently created
     */
    School create(School school);

    /**
     * 根据名称和地址创建School并返回对象id
     *
     * @param name school name
     * @param address school address
     * @return id of school currently created
     */
    int create(String name, String address);
}
