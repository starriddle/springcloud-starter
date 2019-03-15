package com.starriddle.starter.springcloud.config.eureka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CYL
 * @date 2019-03-15
 */
@Slf4j
@RestController
@RequestMapping("/index")
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String serverName;

    @RequestMapping()
    public String index(){
        log.info("server:{}, port:{}", serverName, serverPort);
        return "Hello World!";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "World", required = false) String name){
        log.info("server:{}, port:{}, param-name:{}", serverName, serverPort, name);
        String msg = "Hello " + name + "! —— server: " + serverName + ", port: " + serverPort;
        return msg;
    }

}
