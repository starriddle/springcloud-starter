package com.cyl.demo.feign.client.config;

import com.cyl.demo.feign.client.feign.ServerApi;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CYL
 * @date 2018-04-25
 */
@Configuration
public class serverConfig {

    @Bean
    public ServerApi getContractService() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(ServerApi.class, "http://localhost:9001");
    }

}
