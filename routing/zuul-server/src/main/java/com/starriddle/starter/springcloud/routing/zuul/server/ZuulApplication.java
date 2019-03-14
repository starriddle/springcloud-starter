package com.starriddle.starter.springcloud.routing.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Spring Cloud Zuul 网关 (zuul 1 进入维护期)
 * @author CYL
 * @date 2019-03-14
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

}
