package com.cyl.demo.framework.chapter2.util;

/**
 * 字符串工具类
 *
 * @author CYL
 * @date 2018-02-01
 */
public class StringUtil {

    /**
     * 判断字符串是否为空（包括多个空白字符）
     *
     * @param str 需要判断的字符串
     * @return 如字符串为null，空字符串，纯以空白字符组成的字符串，则返回true；如字符串不为null且含有非空白字符，则返回false
     */
    public static boolean isEmpty(String str){
        if (str != null){
            str = str.trim();
        }
        return str == null || str.length() == 0;
    }

    /**
     * 判断字符串是否非空（含有非空白字符），与isEmpty()方法互斥
     * @see StringUtil#isEmpty(String)
     *
     * @param str 需要判断的字符串
     * @return 如字符串不为空则返回true，否则返回false
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
