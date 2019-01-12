package com.starriddle.starter.springcloud.admin.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CYL
 * @date 2018-03-31
 */
@RestController
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String serverName;

    @RequestMapping("/")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "World") String name){
        return "Hello " + name + "! —— server: " + serverName + ", port: " + serverPort;
    }

}
