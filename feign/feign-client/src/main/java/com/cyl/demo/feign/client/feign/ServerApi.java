package com.cyl.demo.feign.client.feign;

import com.cyl.demo.feign.client.entity.Dept;
import com.cyl.demo.feign.client.entity.Emp;
import com.cyl.demo.feign.client.entity.Emp2;
import com.cyl.demo.feign.client.entity.Org;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.time.LocalDate;
import java.util.List;

/**
 * @author CYL
 * @date 2018-04-25
 */

@Headers({"Content-Type: application/json", "Accept: application/json"})
public interface ServerApi {

    @RequestLine("GET /emp/index") // 不与springcloud集成，只能使用Feign自己的@RequestLine注释
    String index();

    @RequestLine("POST /emp/create")
    boolean create(Emp emp);

    @RequestLine("POST /emp/update")
    boolean update(Emp emp);

    @RequestLine("GET /emp/getById?id={id}")
    Emp getById(@Param("id") long id); // 不使用@Param注释，默认使用Body参数，和POST请求，注释中GET请求无效

    @RequestLine("GET /emp/getEmp2ById?id={id}")
    Emp2 getEmp2ById(@Param("id") long id);

    @RequestLine("GET /emp/getByDept")
    List<Emp> getByDept(@Param("dept") Dept dept);

    @RequestLine("GET /emp/getByOrg")
    List<Emp> getByOrg(Org org);

    @RequestLine("GET /emp/getByDeptAndOrg")
    List<Emp> getByDeptAndOrg(@Param("dept") Dept dept, @Param("org") Org org);

    @RequestLine("GET /emp/getByCondition")
    List<Emp> getByCondition(@Param("name") String name, @Param("name") long age, @Param("birthday") LocalDate birthday, @Param("dept") Dept dept, @Param("org") Org org);
}
