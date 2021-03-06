package com.starriddle.starter.springcloud.config.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 收到 actuator 模块支持的 POST:/actuator/refresh 请求时，会从配置中心拉取
 * 最新配置信息，@RefreshScope 注解的 Bean 其中自动注入的配置会更新为最新值，
 * 而不需要服务重新启动
 *
 * 使用spring cloud bus后，通过消息的发布和消费来更新配置，而不是refresh端口，
 * 此时与端口搭配的 @RefreshScope 注解也不再需要，所有配置都会被更新
 *
 * @author CYL
 * @date 2019-03-15
 */
@Slf4j
//@RefreshScope
@RestController
@RequestMapping("/index")
public class IndexController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String serverName;

    @Value("${message.fresh}")
    private String freshMsg;

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

    @RequestMapping("/msg")
    public String message(){
        log.info("server:{}, port:{}", serverName, serverPort);
        String msg = "current msg: (" + freshMsg + ") —— server: " + serverName + ", port: " + serverPort;
        return msg;
    }

}
