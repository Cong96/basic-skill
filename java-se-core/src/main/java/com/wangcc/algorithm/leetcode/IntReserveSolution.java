package com.wangcc.algorithm.leetcode;

/**
 * @Author: BryantCong
 * @Date: 2019/10/29 10:22
 * @Description:
 */
public class IntReserveSolution {

    public static void main(String[] args) {
        int i = 532;
        System.out.println(i % 10);

        System.out.println(i / 10);

        int j = Integer.MAX_VALUE + 7;
        System.out.println(j);
    }


    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
