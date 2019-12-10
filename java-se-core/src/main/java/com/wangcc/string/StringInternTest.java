package com.wangcc.string;

/**
 * @Author: BryantCong
 * @Date: 2019/9/15 18:41
 * @Description:
 */
public class StringInternTest {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);//false
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);//true
        String s5=new String("111").intern();
        String s6=new String("111").intern();
        System.out.println(s5==s6);//true
        String ss=new String("111");
        String ss1=ss.intern();
        System.out.println(s6==ss1);//true
        String s7=new String("11111");
        String s8=s7.intern();
        System.out.println(s7==s8);//false

        String s9=new String("11111");
        String s10=s9.intern();
        System.out.println(s8==s10);//true
    }
}
