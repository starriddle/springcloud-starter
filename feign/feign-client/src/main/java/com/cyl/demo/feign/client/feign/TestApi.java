package com.cyl.demo.feign.client.feign;

import com.cyl.demo.feign.client.entity.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * content-type使用@Header注释，既可以定义在类上，也可以定义在方法上，作用范围不同
 * @author CYL
 * @date 2018-04-27
 */
@Headers({"Content-Type: application/json", "Accept: application/json"})
public interface TestApi {
    /**
     * 使用json类型，
     * 1. 可以不使用Body参数, 服务端也不能使用Body接收
     *      只能使用@Param注释，不能使用Body参数，
     *      同时url地址中必须写上参数
     *      GET/POST都可以用
     * 2. 可以使用最多一个Body参数，服务端只能使用Body参数接受，
     *      Body参数可以是任意类型，只要json编解码器支持
     *      其他参数只能使用@Param注释
     *      只能使用POST方式，即使定义了GET，实际也会使用POST
     *
     * @param i
     * @return
     */
    @RequestLine("GET /test/int?i={i}")
    int testInt1(@Param("i") int i); // 测试基本类型

    @RequestLine("GET /test/int")
    int testInt2(int i); //使用body参数，注释中GET被忽略，使用POST


    /**
     * json与String的冲突
     * Body参数为String，或返回类型为String，（@Param参数直接写入url，不受影响）
     * 通过Feign调用时会使用指定json编解码器进行转换
     * Feign的默认编解码器只支持String或bute[]，不支持其他类型
     * 其他如Gson/Jackson等不支持String，
     * 编码要求类拥有toString方法，解码要求类拥有默认构造器（空构造器，setter/getter）
     * 解码时不支持没有默认构造器的LocalDate，（支持编码LocalDate，因其有toString方法）
     *
     * 可通过自定义编解码器来解决不受支持的类型
     *
     * @param s
     * @return
     */
    @RequestLine("GET /test/string?s={s}")
    String testString1(@Param("s") String s); // 测试传输/返回String

    @RequestLine("POST /test/string")
    String testString2(String s); // 测试传输/返回String

    /**
     * 服务端解析传入的数据出错，提示LocalDate没有构造器
     * @param date
     * @return
     */
    @RequestLine("GET /test/localdate?date={date}")
    LocalDate testLocalDate1(@Param("date") LocalDate date); // 测试传输/返回 LocalDate

    @RequestLine("POST /test/localdate")
    LocalDate testLocalDate2(LocalDate date); // 测试传输/返回 LocalDate

    /**
     * 非基本类型服务端无法获取@Param参数
     * 服务端采用无注释参数，获取到的为默认构造器生成的新对象 如new User()
     * 服务端采用@RequestParam，直接返回错误信息，提示无法将String转换为User
     *
     * 返回类型没问题，客户端可以正常解析
     * @param user
     * @return
     */
    @RequestLine("GET /test/user?user={user}")
    User testUser1(@Param("user") User user); // 测试传输/返回 User

    @RequestLine("POST /test/user")
    User testUser2(User d); // 测试传输/返回 User


    // ----------------


    /**
     * 默认@Headers
     * 只能使用@Param注释，不能使用Body参数，
     * 同时url地址中必须写上参数
     * 服务端也不能使用Body接收
     * GET/POST都可以用
     * @param i
     * @return
     */
    @RequestLine("GET /test/test1?i={i}")
    int test101(@Param("i") int i);

    @RequestLine("POST /test/test2?i={i}&s={s}&l={l}&m={m}&u={u}")
    int test102(@Param("i") int i, @Param("s") String s, @Param("l")List<Integer> l, @Param("m")Map<Integer, String> m, @Param("u") User user);


}
