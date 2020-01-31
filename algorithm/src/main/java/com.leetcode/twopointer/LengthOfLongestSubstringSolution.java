package com.leetcode.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LengthOfLongestSubstringSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 11:08
 * @Version V1.0
 * <p>
 * 最长不重复子串
 **/
public class LengthOfLongestSubstringSolution {

    public static void main(String[] args) {
        LengthOfLongestSubstringSolution lengthOfLongestSubstringSolution = new LengthOfLongestSubstringSolution();
        System.out.println(lengthOfLongestSubstringSolution.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length = s.length();
        int maxLen = 0;
        Map<Character, Integer> windows = new HashMap<>();
        while (right < length) {
            char rightChar = s.charAt(right);
            windows.put(rightChar, windows.getOrDefault(rightChar, 0) + 1);
            while (windows.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                windows.put(leftChar, windows.get(leftChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
