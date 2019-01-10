package com.starriddle.starter.springcloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.internal.logging.Logger;


/**
 * @author CYL
 * @date 2018-03-31
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String serverName;

    @RequestMapping("/index")
    public String index(@RequestParam(name = "name", defaultValue = "World", required = false) String name){

        logger.info(client.description());
        logger.info(client.getServices().toString());
        logger.info(client.getInstances("hello-server").toString());

        String msg;
        if ("World".equals(name)){
            msg = "Hello World!";
        } else {
            msg = "Hello " + name + "! —— server: " + serverName + ", port: " + serverPort;
        }
        return msg;
    }

}
