package com.cyl.hessian.service;

import java.io.InputStream;

public interface FileUploadService {

    /**
     * 上传文件
     *
     * @param fileName 上传的文件名
     * @param inputStream 上传文件的输入流
     */
    public void upload(String fileName, InputStream inputStream);

}
