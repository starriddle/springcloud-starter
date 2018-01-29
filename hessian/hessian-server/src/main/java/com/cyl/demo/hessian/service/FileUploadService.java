package com.cyl.demo.hessian.service;

import java.io.InputStream;

/**
 * 文件上传服务接口
 *
 * @author CYL
 * @date 2018-01-29
 */
public interface FileUploadService {

    /**
     * 上传文件
     *
     * @param fileName 上传的文件名
     * @param inputStream 上传的文件的输入流
     */
    public void upload(String fileName, InputStream inputStream);

}
