package com.starriddle.starter.springcloud.routing.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * SpringCloud Eureka Server 启动类
 *
 * @author chen
 * @date 2019-01-10
 */
@SpringBootApplication
@EnableEurekaServer
public class RoutingEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoutingEurekaApplication.class, args);
    }

}
