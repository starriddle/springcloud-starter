package com.starriddle.starter.springcloud.routing.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author chen
 * @date 2019-01-10
 */
@SpringBootApplication
@EnableConfigServer
public class RoutingConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoutingConfigApplication.class, args);
    }
}
