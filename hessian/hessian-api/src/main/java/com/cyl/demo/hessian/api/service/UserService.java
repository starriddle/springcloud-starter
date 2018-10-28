package com.cyl.demo.hessian.api.service;

import com.cyl.demo.hessian.api.entity.User;

/**
 * 用户 服务
 *
 * @author CYL
 * @date 2018-10-27
 */
public interface UserService {

    /**
     * 统计User数量
     *
     * @return
     */
    int count();

    /**
     * 根据Id获取User
     *
     * @param id
     * @return
     */
    User getById(Integer id);

    /**
     * 根据传入的对象创建User并返回对象Id
     *
     * @param user
     * @return
     */
    Integer create(User user);

    /**
     * 根据姓名，年龄，地址创建User并返回对象
     * @param name
     * @param age
     * @param address
     * @return
     */
    User create(String name, Integer age, String address);

}
