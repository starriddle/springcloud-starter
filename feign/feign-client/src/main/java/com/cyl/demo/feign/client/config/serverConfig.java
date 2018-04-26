package com.cyl.demo.feign.client.config;

import com.cyl.demo.feign.client.feign.EmpApi;
import com.cyl.demo.feign.client.feign.ServerApi;
import com.cyl.demo.feign.client.feign.UserApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 可以对Feign设置 与服务端通讯 所用的编解码器
 * 如使用Gson，当服务端返回String时，Gson解码器无法解码，会报错
 * 使用默认编解码器，可以正常读取服务端返回的String
 *
 * @author CYL
 * @date 2018-04-25
 */
@Configuration
@EnableAutoConfiguration
public class serverConfig {

    static final Gson GSON;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.setLenient();
        GSON = builder.create();
    }

    @Bean
    public ServerApi registServerApi() {
        return Feign.builder()
//                .encoder(new GsonEncoder(GSON))
//                .decoder(new GsonDecoder(GSON))
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(ServerApi.class, "http://localhost:9001");
    }

    @Bean
    public UserApi registUserApi() {
        return Feign.builder()
                .encoder(new GsonEncoder(GSON))
                .decoder(new GsonDecoder(GSON))
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(UserApi.class, "http://localhost:9001");
    }

    @Bean
    public EmpApi registEmpApi() {
        return Feign.builder()
                .encoder(new GsonEncoder(GSON))
                .decoder(new GsonDecoder(GSON))
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(EmpApi.class, "http://localhost:9001");
    }

}
