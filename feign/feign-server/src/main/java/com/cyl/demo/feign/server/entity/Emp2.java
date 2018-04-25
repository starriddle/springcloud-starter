package com.cyl.demo.feign.server.entity;

import lombok.Data;

/**
 * @author CYL
 * @date 2018-04-25
 */
@Data
public class Emp2 {

    /**
     * emp id
     */
    private long id;
    /**
     * emp name
     */
    private String name;
    /**
     * emp age
     */
    private int age;
    /**
     * emp birthday
     */
    private String birthday;
    /**
     * emp address
     */
    private String address;
    /**
     * emp dept id
     */
    private long deptId;
    /**
     * emp org id
     */
    private long orgId;

    public Emp2(long id, String name, int age, String birthday, String address, long deptId, long orgId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.address = address;
        this.deptId = deptId;
        this.orgId = orgId;
    }
}
