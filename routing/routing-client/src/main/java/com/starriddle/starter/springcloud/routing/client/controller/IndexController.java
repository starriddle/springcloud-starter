package com.starriddle.starter.springcloud.routing.client.controller;

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
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String serverName;

    @RequestMapping("/index")
    public String index(){
        log.info("index server:{}, port:{}", serverName, serverPort);
        String msg = "index::Hello World! —— server: " + serverName + ", port: " + serverPort;
        return msg;
    }

    @RequestMapping("/hello")
    public String hello(){
        log.info("hello server:{}, port:{}", serverName, serverPort);
        String msg = "hello::Hello World! —— server: " + serverName + ", port: " + serverPort;
        return msg;
    }

    @RequestMapping("/index/hello")
    public String hello2(@RequestParam(name = "name", defaultValue = "World", required = false) String name){
        log.info("hello2 server:{}, port:{}, param-name:{}", serverName, serverPort, name);
        String msg = "index/hello::Hello " + name + "! —— server: " + serverName + ", port: " + serverPort;
        return msg;
    }

    @RequestMapping("/a/hello")
    public String hello3(@RequestParam(name = "name", defaultValue = "World", required = false) String name){
        log.info("hello3 server:{}, port:{}, param-name:{}", serverName, serverPort, name);
        String msg = "a/hello::Hello " + name + "! —— server: " + serverName + ", port: " + serverPort;
        return msg;
    }

}
