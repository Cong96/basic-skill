package com.leetcode.dp.again;

/**
 * @Author: BryantCong
 * @Date: 2019/12/13 10:20
 * @Description: 我们来绘图思考下
 * 0-1
 * 0-2
 * <p>
 * 0-3    1-2 是我们要求在这次操作能够得到的结果，显然在0-2这轮操作中，我们能够得到结果，依次类推，我们就能够确认我们能够以局部选择推算到全局
 * 0-4
 * 0-5
 * <p>
 * 如何让我们下一次的操作所需要的内容上一次操作一定能够提供到
 * 也就是所谓的状态转移方程的选定，以及如何正确的使用状态转移方程
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
        //边界条件先处理
        if (s.length() <= 1) {
            return s;
        }
        boolean dp[][] = new boolean[s.length()][s.length()];
        Integer maxLen = 1;
        Integer start = 0;
        for (int right = 1; right < s.length(); right++) {
            for (int left = 0; left < right; left++) {
                //right-left<=2证明中间最多只有一个元素，那么这种情况下，left,right区间构成的子串必然是回文的
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                        start = left;
                    }
                }
            }
        }
        return maxLen == 1 ? s.substring(0, 1) : s.substring(start, start + maxLen);
    }
}
