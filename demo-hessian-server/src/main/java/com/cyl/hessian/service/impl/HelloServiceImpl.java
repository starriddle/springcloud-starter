package com.cyl.hessian.service.impl;

import com.cyl.hessian.entity.User;
import com.cyl.hessian.service.HelloService;

public class HelloServiceImpl implements HelloService {

  @Override
  public User getUser() {
    return new User("Hessian");
  }

}
