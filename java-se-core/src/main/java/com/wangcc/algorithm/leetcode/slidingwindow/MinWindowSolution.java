package com.wangcc.algorithm.leetcode.slidingwindow;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2019/12/2 11:17
 * @Description:
 */
public class MinWindowSolution {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        MinWindowSolution minWindowSolution=new MinWindowSolution();
        System.out.println(minWindowSolution.minWindow(s,t));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> windows = Maps.newHashMap();
        Map<Character, Integer> needs = Maps.newHashMap();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int right = 0;
        int left = 0;
        int match = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                windows.put(c1, windows.getOrDefault(c1, 0) + 1);
                if (needs.get(c1).equals(windows.get(c1))) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    windows.put(c2, windows.get(c2) - 1);
                    if (windows.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}
