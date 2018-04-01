package com.cyl.springcloud.helloserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// @EnableEurekaClient // 只限于在eureka中使用
@EnableDiscoveryClient // 在所有springcloud的discoveryclient中都适用: eureka, consle, zookeeper
@SpringBootApplication
public class HelloServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloServerApplication.class, args);
    }
}
