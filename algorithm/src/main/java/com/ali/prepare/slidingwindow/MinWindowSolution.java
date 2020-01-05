package com.ali.prepare.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2020/1/5 20:13
 * @Description:
 */
public class MinWindowSolution {
    public static void main(String[] args) {

    }

    public String minWindow(String str, String target) {
        Map<Character, Integer> windowsMap = new HashMap<>();
        Map<Character, Integer> needsMap = new HashMap<>();
        for (char c : target.toCharArray()) {
            needsMap.put(c, needsMap.getOrDefault(c, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        int right = 0;
        int match = 0;
        while (right < str.length()) {
            char rightChar = str.charAt(right);
            if (needsMap.containsKey(rightChar)) {
                windowsMap.put(rightChar, windowsMap.getOrDefault(rightChar, 0) + 1);
                if (windowsMap.get(rightChar).equals(needsMap.get(rightChar))) {
                    match++;
                }
            }
            right++;
            while (match == needsMap.size()) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }
                char leftChar = str.charAt(left);
                if (needsMap.containsKey(leftChar)) {
                    windowsMap.put(leftChar, windowsMap.get(leftChar) - 1);
                    if (windowsMap.get(leftChar) < needsMap.get(leftChar)) {
                        match--;
                    }
                }
                left++;
            }

        }
        return min == Integer.MAX_VALUE ? null : str.substring(left, min);
    }
}
