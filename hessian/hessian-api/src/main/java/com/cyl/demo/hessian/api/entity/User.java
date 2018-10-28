package com.cyl.demo.hessian.api.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一个User类，实现序列化接口，
 * User实现了序列化接口后就可以进行序列化，
 * 然后就可以通过网络将序列化后的user传输到另一台计算机上
 *
 * @author CYL
 * @date 2018-10-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 6471085784504575936L;

    private Integer id;
    
    private String name;
    
    private Integer age;
    
    private String address;

}
