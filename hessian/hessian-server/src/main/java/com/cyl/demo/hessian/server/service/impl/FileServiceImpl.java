package com.cyl.demo.hessian.server.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.cyl.demo.hessian.api.service.FileService;

/**
 * 文件 服务 的 具体实现类
 *
 * @author CYL
 * @date 2018-10-27
 * @see FileService
 */
public class FileServiceImpl implements FileService {

    @Override
    public void upload(String fileName, InputStream inputStream) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //获取客户端传递的InputStream
            bis = new BufferedInputStream(inputStream);
            //创建文件输出流
            bos = new BufferedOutputStream(new FileOutputStream("/home/chen/Downloads/temp/server/" + fileName));
            byte[] buffer = new byte[8192];
            int r = bis.read(buffer, 0, buffer.length);
            while (r > 0) {
                bos.write(buffer, 0, r);
                r = bis.read(buffer, 0, buffer.length);
            }
            System.out.println("-------文件上传成功！-------------");
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到: " + e.getMessage());
            e.printStackTrace();
        }catch (IOException e) {
            System.out.println("流读写错误: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    System.out.println("输出流关闭异常: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    System.out.println("输入流关闭异常: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

}
