package com.starriddle.starter.springcloud.routing.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过Bean方式 注入路由配置
 *
 * @author CYL
 * @date 2019-03-15
 */
@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("rewrite-a", r -> r.path("/A/**")
                        .filters(f -> f.rewritePath("/A", ""))
                        .uri("http://localhost:12001"))
                .route("set-b", r -> r.path("/b/{segment}")
                        .filters(f -> f.setPath("/{segment}"))
                        .uri("http://localhost:12002"))
                .build();
    }
}
