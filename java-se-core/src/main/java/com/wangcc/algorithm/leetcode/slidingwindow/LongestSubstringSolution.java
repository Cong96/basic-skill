package com.wangcc.algorithm.leetcode.slidingwindow;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2019/12/1 20:12
 * @Description: 其实就是一个队列, 比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
 * <p>
 * 如何移动？
 * <p>
 * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
 * <p>
 * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
 * <p>
 * int left = 0, right = 0;
 * <p>
 * while (right < s.size()) {
 * window.add(s[right]);
 * right++;
 * <p>
 * while (valid) {
 * window.remove(s[left]);
 * left++;
 * }
 * }
 * <p>
 * 作者：labuladong
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-suan-fa-tong-yong-si-xiang-by-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 */
public class LongestSubstringSolution {
    public static void main(String[] args) {
        String s = "abcdddabbbbb";
        LongestSubstringSolution substringSolution = new LongestSubstringSolution();

        System.out.println(substringSolution.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> windows = Maps.newHashMap();
        int right = 0;
        int left = 0;
        int max = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windows.put(rightChar, windows.getOrDefault(rightChar, 0) + 1);
            while (windows.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                windows.put(leftChar, windows.get(leftChar) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;

        }
        return max;
    }

}
