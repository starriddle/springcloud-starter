package com.cyl.demo.hessian.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 6471085784504575936L;
    
    private String name;
    
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
