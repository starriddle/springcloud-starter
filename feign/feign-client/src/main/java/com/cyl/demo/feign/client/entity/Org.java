package com.cyl.demo.feign.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author CYL
 * @date 2018-04-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
