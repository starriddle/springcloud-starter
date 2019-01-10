package com.starriddle.starter.springcloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SpringCloud Eureka Client 启动类<p/>
 *
 * 客户端注解：<br>
 *
 * EnableEurekaClient
 * 不推荐，仅限在 SpringCloud Eureka 中使用 <br>
 *
 * EnableDiscoveryClient
 * 推荐，在所有 SpringCloud 的 Discovery Client中都适用: eureka, consul, zookeeper
 *
 * @author CYL
 * @date 2019-01-10
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}
