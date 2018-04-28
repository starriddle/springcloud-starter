package com.cyl.demo.feign.client;

import com.cyl.demo.feign.client.entity.User;
import com.cyl.demo.feign.client.feign.TestApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.*;

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
    public void testString(){ // 使用Gson/Jackson默认的处理会出现问题，使用自定义编解码器不会有问题
        System.out.println(server.testString1("test \"String\" as Form Parameter")); // 服务器接收String正常，客户端接收String时解码出错
        System.out.println(server.testString2("test \"String\" as Body Parameter")); // 服务端/客户端接收String时解码都存在问题
    }

    @Test
    public void testArray(){
        String[] array = new String[]{"aaa", "bbb", "ccc"};
        System.out.println(server.testArray1(array));
        System.out.println(server.testArray2(array));
    }

    @Test
    public void testList(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        System.out.println(server.testList1(list));
        System.out.println(server.testList2(list));
    }

    @Test
    public void testMap(){
        Map<String,Long> map = new HashMap<>();
        map.put("first", 101L);
        map.put("second", 202L);
        System.out.println(server.testMap1(map));
        System.out.println(server.testMap2(map));
    }

    @Test
    public void testDate(){
        System.out.println(server.testDate1(new Date()));
        System.out.println(server.testDate2(new Date()));
    }

    @Test
    public void testTime(){
        System.out.println(server.testTime1(new Time(1,1,1)));
        System.out.println(server.testTime2(new Time(2,2,2)));
    }

    @Test
    public void testBigDecimal(){
        System.out.println(server.testBigDecimal1(new BigDecimal("12345678901234567890")));
        System.out.println(server.testBigDecimal2(new BigDecimal("123456789012345678901234567890")));
    }

    @Test
    public void testUser(){
        User user = new User(1, "joke", 18, "1990-09-09", "Canada", 10,100);
//        System.out.println(server.testUser1(user)); // 服务端无法将String转换成User
        System.out.println(server.testUser2(user));
    }

    @Test
    public void testLocalDate(){
//        System.out.println(server.testLocalDate1(LocalDate.now())); //服务端无法解析
//        System.out.println(server.testLocalDate2(LocalDate.now())); //服务端无法解析
//        System.out.println(server.testLocalDate3()); // 客户端解析正常
    }
}
