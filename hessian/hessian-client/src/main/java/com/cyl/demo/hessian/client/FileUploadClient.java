package com.cyl.demo.hessian.client;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.cyl.demo.hessian.service.FileUploadService;

public class FileUploadClient {
    public static void main(String[] args) throws MalformedURLException, FileNotFoundException {
        String url = "http://127.0.0.1:8080/hessian-server/upload";
        //创建HessianProxyFactory实例
        HessianProxyFactory factory = new HessianProxyFactory();
        //获得Hessian服务的远程引用
        FileUploadService service = (FileUploadService) factory.create(FileUploadService.class, url);
        //读取需要上传的文件
        InputStream is = new BufferedInputStream(new FileInputStream("D:/upload/source/test.txt"));
        //调用远程服务上传文件。
        service.upload("test.txt", is);
    }
}
