package com.cyl.demo.feign.client.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author CYL
 * @date 2018-04-25
 */
@Data
public class Org {

    /**
     * org id
     */
    private long id;
    /**
     * org name
     */
    private String name;
    /**
     * org address
     */
    private String address;
    /**
     * org found day
     */
    private LocalDate foundDay;
}
