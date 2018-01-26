package com.cyl.hessian.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.cyl.hessian.service.FileUploadService;

public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public void upload(String fileName, InputStream inputStream) {
        
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //获取客户端传递的InputStream
            bis = new BufferedInputStream(inputStream);
            //创建文件输出流
            bos = new BufferedOutputStream(new FileOutputStream("D:/upload/target/" + fileName));
            byte[] buffer = new byte[8192];
            int r = bis.read(buffer, 0, buffer.length);
            while (r > 0) {
                bos.write(buffer, 0, r);
                r = bis.read(buffer, 0, buffer.length);
            }
            System.out.println("-------文件上传成功！-------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
