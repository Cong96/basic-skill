package com.leetcode.ali;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 21:08
 * @Description:
 */
public class PatternSolution {

    public static void main(String[] args) {

    }

    public boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        Map<Character, String> reflectMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (reflectMap.containsKey(pattern.charAt(i))) {
                if (!strs[i].equals(reflectMap.get(pattern.charAt(i)))) {
                    return true;
                }
            } else {
                if (reflectMap.containsValue(pattern.charAt(i))) {
                    return false;
                }
                reflectMap.put(pattern.charAt(i), strs[i]);

            }
        }

        return true;
    }
}
