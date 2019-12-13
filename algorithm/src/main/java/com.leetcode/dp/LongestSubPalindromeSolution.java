package com.leetcode.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/12/12 10:58
 * @Description: 最大回文子串
 * <p>
 * <p>
 * 动态规划的实现分为两种，有递归和迭代。
 * 递归一般是自顶向下，依赖于子问题优化函数的结果，只有子问题完全求出，也就是子问题的递归返回结果，原问题才能求解。
 * <p>
 * 迭代法，就是巧妙的安排求解顺序，从最小的子问题开始，自下而上求解。每次求新的问题时，子问题的解已经计算出来了。
 * <p>
 * 作者：郑不知
 * 链接：https://www.zhihu.com/question/27363814/answer/36327479
 * 来源：知乎
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 回文子串
 * <p>
 * 状态转移方程
 * dp[i][j] = (a[i]==a[j])&&dp[i+1][j-1];
 * <p>
 * 为什么可以用动态规划呢？
 * 因为
 */
public class LongestSubPalindromeSolution {


    public String longestSubPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];
        // abcdedcba
        //   l   r
        // 如果 dp[l, r] = true 那么 dp[l + 1, r - 1] 也一定为 true
        // 关键在这里：[l + 1, r - 1] 一定至少有 2 个元素才有判断的必要
        // 因为如果 [l + 1, r - 1] 只有一个元素，不用判断，一定是回文串
        // 如果 [l + 1, r - 1] 表示的区间为空，不用判断，也一定是回文串
        // [l + 1, r - 1] 一定至少有 2 个元素 等价于 l + 1 < r - 1，即 r - l >  2

        // 写代码的时候这样写：如果 [l + 1, r - 1]  的元素小于等于 1 个，即 r - l <=  2 ，就不用做判断了

        // 因为只有 1 个字符的情况在最开始做了判断
        // 左边界一定要比右边界小，因此右边界从 1 开始
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                // 区间应该慢慢放大
                // 状态转移方程：如果头尾字符相等并且中间也是回文
                // 在头尾字符相等的前提下，如果收缩以后不构成区间（最多只有 1 个元素），直接返回 True 即可
                // 否则要继续看收缩以后的区间的回文性
                // 重点理解 or 的短路性质在这里的作用
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestPalindrome) {
                        longestPalindrome = r - l + 1;
                        longestPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }
}
