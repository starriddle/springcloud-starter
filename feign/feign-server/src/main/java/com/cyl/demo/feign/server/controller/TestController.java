package com.cyl.demo.feign.server.controller;

import com.cyl.demo.feign.server.entity.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CYL
 * @date 2018-04-27
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping("/int")
    int testInt1(int i){
        System.out.println("GET test int i=" + i);
        int result = i * 5;
        System.out.println("return: " + result);
        return result;
    }

    @PostMapping("/int")
    int testInt2(@RequestBody int i){
        System.out.println("POST test int i=" + i);
        int result = i * 5;
        System.out.println("return: " + result);
        return result;
    }

    @GetMapping("/string")
    String testString1(String s){
        System.out.println("GET test string s=" + s);
        String result = s + " - over";
        System.out.println("return: " + result);
        return result;
    }

    @PostMapping("/string")
    String testString2(@RequestBody String s){
        System.out.println("POST test string s=" + s);
        String result = s + " - over";
        System.out.println("return: " + result);
        return result;
    }

    @GetMapping("/localdate")
    LocalDate testLocalDate1(LocalDate date){
        System.out.println("GET test localdate date=" + date);
        LocalDate result = date.plusMonths(2);
        System.out.println("return: " + result);
        return result;
    }

    @PostMapping("/localdate")
    LocalDate testLocalDate2(@RequestBody LocalDate date){
        System.out.println("POST test localdate date=" + date);
        LocalDate result = date.plusMonths(2);
        System.out.println("return: " + result);
        return result;
    }

    @GetMapping("/list")
    List<String> testList1(List<String> param){
        System.out.println("GET test list : " + param);
        List<String> result = Arrays.asList("ccc","bbb","aaa");
        System.out.println("return: " + result);
        return result;
    }

    @PostMapping("/list")
    List<String> testList2(@RequestBody List<String> param){
        System.out.println("POST test list : " + param);
        List<String> result = Arrays.asList("ccc","bbb","aaa");
        System.out.println("return: " + result);
        return result;
    }

    @GetMapping("/map")
    Map<String, LocalDate> testMap1(Map<String, LocalDate> param){
        System.out.println("GET test map : " + param);
        Map<String, LocalDate> result = new HashMap<>();
        result.put("today", LocalDate.now());
        result.put("tomorrow", LocalDate.now().plusDays(1));
        System.out.println("return: " + result);
        return result;
    }

    @PostMapping("/map")
    Map<String, LocalDate> testMap2(@RequestBody Map<String, LocalDate> param){
        System.out.println("POST test map : " + param);
        Map<String, LocalDate> result = new HashMap<>();
        result.put("today", LocalDate.now());
        result.put("tomorrow", LocalDate.now().plusDays(1));
        System.out.println("return: " + result);
        return result;
    }

    @GetMapping("/user")
    User testUser1(@RequestParam("user") User user){
        System.out.println("GET test User : " + user);
        User result = new User(1002, "1002", 22, "2000-10-02", "china", 10002, 100002);
        System.out.println("return: " + result);
        return result;
    }

    @PostMapping("/user")
    User testUser2(@RequestBody User param){
        System.out.println("POST test User : " + param);
        User result = new User(1002, "1002", 22, "2000-10-02", "china", 10002, 100002);
        System.out.println("return: " + result);
        return result;
    }

    // ---------------------


    @PostMapping("/test102")
    User test2(int i, String s, List<Integer> l, Map<Integer, String> m, User user){
        System.out.println("POST test2 i=" + i + ", s=" + s + ", l=" + l + ",m=" + m + ",u=" + user);
        return user;
    }

}
