package com.cyl.demo.hessian.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.cyl.demo.hessian.api.service.FileService;

/**
 * 文件服务 客户端
 *
 * @author CYL
 * @date 2018-10-27
 */
public class FileClient {

    private static FileService service = null;

    static {
        //Hessian服务的URL地址
        String url = "http://127.0.0.1:8080/hessian-server/file";
        //创建HessianProxyFactory实例
        HessianProxyFactory factory = new HessianProxyFactory();
        //启用接口的重载方法
        factory.setOverloadEnabled(true);
        //socket连接超时时间(毫秒)
        factory.setConnectTimeout(1000);
        //获得Hessian服务的远程引用
        try {
            service = (FileService) factory.create(FileService.class, url);
        } catch (MalformedURLException e) {
            System.out.println("创建HessianProxy失败：" + e.getMessage());
        }
    }

    public static void upload() {
        try {
            //读取需要上传的文件
            InputStream is = new FileInputStream("/home/chen/Downloads/temp/client/test.txt");
            //调用远程服务上传文件。
            service.upload("test.txt", is);
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到：" + e.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {
        if (service == null) {
            return;
        }
        upload();
    }
}
