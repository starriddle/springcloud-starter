package com.cyl.demo.framework.chapter2.service;

import com.cyl.demo.framework.chapter2.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * 客户服务接口
 *
 * @author CYL
 * @date 2018-01-29
 */
public interface CustomerService {

    /**
     * 通过关键字查找匹配客户
     * @param keyword 查找的关键字
     * @return 返回匹配关键字的所有客户的链表
     */
    public List<Customer> getCustomerList(String keyword);

    /**
     * 通过ID查找客户
     * @param id 待查找的客户ID
     * @return 返回客户实例
     */
    public Customer getCustomerById(long id);

    /**
     * 创建一个新客户
     * @param fieldMap 待创建的新客户的信息
     * @return 创建成功返回true，否则返回false
     */
    public boolean insertCustomer(Map<String, Object> fieldMap);

    /**
     * 通过ID更新客户信息
     * @param id 需要更新的客户的ID
     * @param fieldMap 需要更新的客户的信息
     * @return 更新成功返回true，否则返回false
     */
    public boolean updateCustomerById(long id, Map<String, Object> fieldMap);

    /**
     * 通过ID删除客户
     * @param id 要删除的客户的ID
     * @return 成功删除返回true，否则返回false
     */
    public  boolean deleteCustomerById(long id);

}
