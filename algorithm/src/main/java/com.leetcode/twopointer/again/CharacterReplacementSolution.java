package com.leetcode.twopointer.again;

/**
 * @Author: BryantCong
 * @Date: 2020/2/27 10:22
 * @Description: * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * *
 * * 注意:
 * * 字符串长度 和 k 不会超过 104。
 * *
 * * 示例 1:
 * *
 * * 输入:
 * * s = "ABAB", k = 2
 * *
 * * 输出:
 * * 4
 * *
 * * 解释:
 * * 用两个'A'替换为两个'B',反之亦然。
 * * 示例 2:
 * *
 * * 输入:
 * * s = "AABABBA", k = 1
 * *
 * * 输出:
 * * 4
 * *
 * * 解释:
 * * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * * 子串 "BBBB" 有最长重复字母, 答案为 4。
 */
public class CharacterReplacementSolution {

    public int characterReplacement(String s, int k) {

        //注意是子串，也就意味着是连续的

        int maxLen = 0;
        int right = 0;
        int left = 0;
        int length = s.length();
        int[] count = new int[26];
        int res = 0;
        while (right < length) {
            count[s.charAt(right) - 'A'] += 1;
            maxLen = Math.max(count[s.charAt(right) - 'A'], maxLen);
            //只有不符合这个while循环的时候，也就意味着符合条件了。所以是在while循环结束后的代码块进行比较
            while (right - left + 1 > k + maxLen) {
                count[s.charAt(left) - 'A'] -= 1;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}