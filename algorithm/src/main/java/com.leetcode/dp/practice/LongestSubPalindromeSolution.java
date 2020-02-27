package com.leetcode.dp.practice;

/**
 * @Author: BryantCong
 * @Date: 2020/2/25 14:26
 * @Description:
 */
public class LongestSubPalindromeSolution {

    public static void main(String[] args) {
        String s = "123";
        System.out.println(s.substring(1, 2));
    }

    public String longestSubPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        int length = s.length();
        //初始的回文串，那就是最开始的第一个字符
        int start = 0;
        int end = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[length][length];
        for (int right = 1; right < length; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (right + 1 - left > maxLen) {
                        start = left;
                        end = right;
                        maxLen = right + 1 - left;
                    }
                }
            }

        }
        return s.substring(start, end + 1);
    }

}