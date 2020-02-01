package com.leetcode.string;

/**
 * @ClassName CountSubstringsSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 16:19
 * @Version V1.0
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CountSubstringsSolution {

    public int countSubstrings(String s) {
        //TODO  动态规划，这题不会就搞笑了兄弟
        if (s.length() <= 1) {
            return 1;
        }
        int length = s.length();
        int count = 0;
        boolean[][] dp = new boolean[length][length];
        for (int right = 1; right < length; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) && (dp[left + 1][right - 1] || right - left < 2)) {
                    dp[left][right] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
