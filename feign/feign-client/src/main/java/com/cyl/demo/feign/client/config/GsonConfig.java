package com.cyl.demo.feign.client.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CYL
 * @date 2018-04-26
 */
@Configuration
public class GsonConfig {

    @Bean
    public Gson registGson(){
        GsonBuilder builder = new GsonBuilder();
        builder.setLenient();
        return builder.create();
    }
}
