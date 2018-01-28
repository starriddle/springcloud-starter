package com.cyl.demo.hessian.serviceimpl;

import com.cyl.demo.hessian.entity.User;
import com.cyl.demo.hessian.service.HelloService;

public class HelloServiceImpl implements HelloService {

  @Override
  public User getUser() {
    return new User("Hessian");
  }

}
