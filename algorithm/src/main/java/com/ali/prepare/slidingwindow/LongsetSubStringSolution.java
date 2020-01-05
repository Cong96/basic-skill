package com.ali.prepare.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2020/1/4 21:45
 * @Description:
 */
public class LongsetSubStringSolution {

    public String longestSubString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int logestSubStringLength = 1;
        Map<Character, Integer> windows = new HashMap<>();
        while (right < str.length()) {
            char rightChar = str.charAt(right);
            windows.put(rightChar, windows.getOrDefault(right, 0) + 1);
            right++;
            while (windows.get(rightChar) > 1) {
                char leftChar = str.charAt(left);
                windows.put(leftChar, windows.get(leftChar) - 1);
                left++;
            }
            if (right - left + 1 > logestSubStringLength) {
                logestSubStringLength = right - left + 1;
                start = left;
            }
        }
        return str.substring(start, start + logestSubStringLength);
    }
}
