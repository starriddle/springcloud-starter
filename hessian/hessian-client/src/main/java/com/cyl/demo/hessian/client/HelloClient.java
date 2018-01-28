package com.cyl.demo.hessian.client;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.cyl.demo.hessian.entity.User;
import com.cyl.demo.hessian.service.HelloService;

public class HelloClient {
    public static void main(String[] args) throws MalformedURLException {
        String url = "http://127.0.0.1:8080/hessian-server/hello";
        HessianProxyFactory factory = new HessianProxyFactory();
        HelloService service = (HelloService) factory.create(HelloService.class, url);
        User user = service.getUser();
        System.out.println("Hello " + user.getName());
    }
}
