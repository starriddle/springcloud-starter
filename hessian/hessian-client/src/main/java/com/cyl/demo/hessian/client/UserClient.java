package com.cyl.demo.hessian.client;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.cyl.demo.hessian.api.entity.User;
import com.cyl.demo.hessian.api.service.UserService;

/**
 * User服务 客户端
 *
 * @author CYL
 * @date 2018-10-27
 */
public class UserClient {

    private static UserService service = null;

    static {
        //在服务器端的web.xml文件中配置的servlet "user" 映射的访问URL地址
        String url = "http://127.0.0.1:8080/hessian-server/user";
        //创建HessianProxyFactory实例
        HessianProxyFactory factory = new HessianProxyFactory();
        //启用接口的重载方法
        factory.setOverloadEnabled(true);
        //socket连接超时时间(毫秒)
        factory.setConnectTimeout(1000);
        //创建UserService接口的实例对象
        try {
            service = (UserService) factory.create(UserService.class, url);
        } catch (MalformedURLException e) {
            System.out.println("创建HessianProxy失败：" + e.getMessage());
        }
    }

    public static void createByParams(){
        User user = service.create("Jack", 21, "New York");
        System.out.println("create: "+user);
    }

    public static void createByUser(){
        Integer id = service.create(new User(null, "Rose", 20, "London"));
        System.out.println("create user id: "+id);
    }

    public static void getById(){
        User user = service.getById(2);
        System.out.println("get user: "+user);
    }

    public static void count(){
        int count = service.count();
        System.out.println("count: "+count);
    }

    public static void main(String[] args) {
        if (service == null) {
            return;
        }
        count();
        createByParams();
        count();
        createByUser();
        count();
        getById();
    }
}
