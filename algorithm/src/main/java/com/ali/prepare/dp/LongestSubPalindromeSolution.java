package com.ali.prepare.dp;

/**
 * @Author: BryantCong
 * @Date: 2020/1/4 17:37
 * @Description: 自下而上  动态规划
 * 自顶向下  递归
 */
public class LongestSubPalindromeSolution {
    public static void main(String[] args) {
            LongestSubPalindromeSolution longestSubPalindromeSolution = new LongestSubPalindromeSolution();

            String s = longestSubPalindromeSolution.longestSubPalindrome("abcccbacdddddd");
            System.out.println(s);

    }


    public String longestSubPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() <= 1) {
            return s;
        }
        int start = 0;
        int maxLen = 1;
        //记录表
        boolean dp[][] = new boolean[s.length()][s.length()];
        dp[0][1] = true;
        //从index 2开始
        for (int right = 2; right < s.length(); right++) {
            for (int left = 0; left < right; left++) {
                //right-left<=2即意味着中间最多有一个元素，那么此时肯定也是回文
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (maxLen < right - left + 1) {
                        maxLen = right - left + 1;
                        start = left;
                    }
                }
            }
        }
        return s.substring(start, maxLen);
    }
}
