package com.leetcode.twopointer.again;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2020/2/27 10:42
 * @Description: 最长不重复子串
 * <p>
 * 因为left已经检查过了，只有不断往right向后检索，才能知道后面有没有惊喜
 */
public class LengthOfLongestSubstringSolution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windowsMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = s.length();
        int res = 0;
        while (right < length) {
            char rightChar = s.charAt(right);
            windowsMap.put(rightChar, windowsMap.getOrDefault(rightChar, 0) + 1);
            while (windowsMap.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                windowsMap.put(leftChar, windowsMap.get(leftChar) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return -1;
    }

}