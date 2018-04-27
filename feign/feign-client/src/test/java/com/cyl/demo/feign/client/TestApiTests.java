package com.cyl.demo.feign.client;

import com.cyl.demo.feign.client.entity.User;
import com.cyl.demo.feign.client.feign.TestApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApiTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    TestApi server;

    @Test
    public void TestInt(){
        System.out.println(server.testInt1(11));
        System.out.println(server.testInt2(11));
    }

    @Test
    public void testString(){
        System.out.println(server.testString1("test String as Form Parameter"));
        System.out.println(server.testString2("test String as Body Parameter"));
    }

    @Test
    public void testLocalDate(){
//        System.out.println(server.testLocalDate1(LocalDate.now())); //服务端解析传入的参数出错，没有构造器
        System.out.println(server.testLocalDate2(LocalDate.now()));
    }

    @Test
    public void testUser(){
        User user = new User(1, "joke", 18, "1990-09-09", "Canada", 10,100);
        System.out.println(server.testUser1(user)); //服务端收不到正确数据
        System.out.println(server.testUser2(user));
    }

}
