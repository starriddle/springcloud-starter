package com.starriddle.starter.springcloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author CYL
 * @date 2018-03-31
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String serverName;

    @Value("${message.custom}")
    private String customMsg;

    @Value("${message.both}")
    private String bothMsg;

    @Value("${message.system}")
    private String systemMsg;

    @Value("${message.profile}")
    private String profileMsg;

    @Value("${message.global}")
    private String globalMsg;

    @Value("${message.fresh}")
    private String freshMsg;

    @RequestMapping("/list")
    public String configList(){
        return "configs:" +
                "\n\tglobal message: " + globalMsg +
                "\n\tsystem message: " + systemMsg +
                "\n\tprofile message: " + profileMsg +
                "\n\tboth message: " + bothMsg +
                "\n\tcustom message: " + customMsg;
    }

    @RequestMapping("/msg")
    public String message(){
        String msg = "current msg: (" + freshMsg + ") —— server: " + serverName + ", port: " + serverPort;
        return msg;
    }

}
