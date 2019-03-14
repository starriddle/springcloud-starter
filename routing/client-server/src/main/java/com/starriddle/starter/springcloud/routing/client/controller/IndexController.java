package com.starriddle.starter.springcloud.routing.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CYL
 * @date 2019-03-14
 */
@Slf4j
@RestController
@RequestMapping("/index")
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String serverName;

    @RequestMapping("/hello")
    public String index(@RequestParam(name = "name", defaultValue = "World", required = false) String name){

        String msg = "Hello " + name + "! —— server: " + serverName + ", port: " + serverPort;
        return msg;
    }

}
