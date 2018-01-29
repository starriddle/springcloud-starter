package com.cyl.demo.hessian.entity;

import java.io.Serializable;

/**
 * 一个User类，实现序列化接口，
 * User实现了序列化接口后就可以进行序列化，
 * 然后就可以通过网络将序列化后的user传输到另一台计算机上
 *
 * @author CYL
 */
public class User implements Serializable {

    private static final long serialVersionUID = 6471085784504575936L;
    
    private String name;

    public User(){

    }
    
    public User(String name) {
        super();
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
