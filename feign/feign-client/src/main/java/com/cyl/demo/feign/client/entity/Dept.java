package com.cyl.demo.feign.client.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author CYL
 * @date 2018-04-25
 */
@Data
public class Dept {

    /**
     * dept id
     */
    private long id;
    /**
     * dept name
     */
    private String name;
    /**
     * dept address
     */
    private String address;
    /**
     * dept org id
     */
    private long orgId;
    /**
     * dept found day
     */
    private LocalDate foundDay;

}
