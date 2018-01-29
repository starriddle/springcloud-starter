package com.cyl.demo.hessian.serviceimpl;

import com.cyl.demo.hessian.entity.User;
import com.cyl.demo.hessian.service.HelloService;

/**
 * HelloService接口的具体实现类
 *
 * @author CYL
 */
public class HelloServiceImpl implements HelloService {

  /**
   * 实现HelloService接口的getUser方法
   *
   * @return 返回一个USer对象
   *
   * @see com.cyl.demo.hessian.service.HelloService#getUser()
   */
  @Override
  public User getUser() {
    return new User("Hessian");
  }

}
