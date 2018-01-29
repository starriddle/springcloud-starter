package com.cyl.demo.hessian.client;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.cyl.demo.hessian.entity.User;
import com.cyl.demo.hessian.service.HelloService;

/**
 * 调用Hessian的客户端
 */
public class HelloClient {
    public static void main(String[] args) throws MalformedURLException {
        //在服务器端的web.xml文件中配置的servlet "hello" 映射的访问URL地址
        String url = "http://127.0.0.1:8080/hessian-server/hello";
        HessianProxyFactory factory = new HessianProxyFactory();
        //创建HelloService接口的实例对象
        HelloService service = (HelloService) factory.create(HelloService.class, url);
        //调用Hessian服务器端的HelloServiceImpl类中的getUser方法来获取一个User对象
        User user = service.getUser();
        System.out.println("Hello " + user.getName());
    }
}
