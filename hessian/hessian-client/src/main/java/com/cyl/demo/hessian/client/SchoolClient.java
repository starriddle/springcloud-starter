package com.cyl.demo.hessian.client;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.cyl.demo.hessian.server.entity.School;
import com.cyl.demo.hessian.server.service.SchoolService;

/**
 * School服务 客户端
 * 
 * @author CYL
 * @date 2018-10-27
 */
public class SchoolClient {

    private static SchoolService service = null;

    static {
        //在服务器端的web.xml文件中配置的servlet "school" 映射的访问URL地址
        String url = "http://127.0.0.1:8080/hessian-server/school";
        //创建HessianProxyFactory实例
        HessianProxyFactory factory = new HessianProxyFactory();
        //启用接口的重载方法
        factory.setOverloadEnabled(true);
        //socket连接超时时间(毫秒)
        factory.setConnectTimeout(1000);
        //创建SchoolService接口的实例对象
        try {
            service = (SchoolService) factory.create(SchoolService.class, url);
        } catch (MalformedURLException e) {
            System.out.println("创建HessianProxy失败：" + e.getMessage());
        }
    }

    public static void createByParam(){
        int id = service.create("Ninghai Middle School", "Zhejiang");
        System.out.println("create school id: "+id);
    }

    public static void createBySchool(){
        School school = service.create(new School(null, "Fudan University", "Shanghai"));
        System.out.println("create: "+school);
    }

    public static void getById(){
        School school = service.getById(2);
        System.out.println("get school: "+school);
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
        createBySchool();
        count();
        createByParam();
        count();
        getById();
    }
}
