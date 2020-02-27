package com.leetcode.twopointer.again;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2020/2/27 10:39
 * @Description: * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * * <p>
 * * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * * <p>
 * * 示例1:
 * * <p>
 * * 输入: s1 = "ab" s2 = "eidbaooo"
 * * 输出: True
 * * 解释: s2 包含 s1 的排列之一 ("ba").
 * *  
 * * <p>
 * * 示例2:
 * * <p>
 * * 输入: s1= "ab" s2 = "eidboaoo"
 * * 输出: False
 */
public class CheckInclusionSolution {

    public boolean checkInclusion(String s1, String s2) {
        //basecase
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s1.length() > s2.length()) {
            return false;
        }
        //TODO
        Map<Character, Integer> matchMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            matchMap.put(c, matchMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = s2.length();
        int match = 0;
        while (right < length) {
            char rightChar = s2.charAt(right);
            if (matchMap.containsValue(rightChar)) {
                windows.put(rightChar, windows.getOrDefault(rightChar, 0) + 1);
                if (matchMap.get(rightChar).equals(windows.get(rightChar))) {
                    match++;
                }
            }
            while (match == matchMap.size()) {
                if (right - left + 1 == s1.length()) {
                    return true;
                }
                char leftChar = s2.charAt(left);
                if (matchMap.containsValue(leftChar)) {
                    windows.put(leftChar, windows.get(leftChar) - 1);
                    if (windows.get(leftChar) < matchMap.get(leftChar)) {
                        match--;
                    }
                }
                left++;
            }
            right++;
        }
        return false;
    }
}