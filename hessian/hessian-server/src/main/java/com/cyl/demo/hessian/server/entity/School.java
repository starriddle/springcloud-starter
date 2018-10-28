package com.cyl.demo.hessian.server.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * School Entity
 *
 * @author CYL
 * @date 2018-10-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School implements Serializable {

    private static final long serialVersionUID = -357222495943001666L;

    private Integer id;

    private String name;

    private String address;
}
