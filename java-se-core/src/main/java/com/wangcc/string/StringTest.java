package com.wangcc.string;

/**
 * @Author: BryantCong
 * @Date: 2019/9/22 19:24
 * @Description:
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "bc";
        /*
         *
         *  该行代码会在编译过程中被优化成
         *     //String s3=new StringBuilder(s1).append(s2).toString();
         *     我们可以通过javap -c 反编译看到这一优化过程
         * 所以s3这个对象不是指向常量池的
         *
         * */
        String s3 = s1 + s2;
        String s4 = "abc";
        System.out.println(s3 == s4);
        final String s5 = "a";
        final String s6 = "bc";
        String s7 = s5 + s6;
        System.out.println(s4 == s7);
    }
}
