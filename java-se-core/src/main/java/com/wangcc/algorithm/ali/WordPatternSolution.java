package com.wangcc.algorithm.ali;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2019/10/31 11:36
 * @Description:
 */
public class WordPatternSolution {

    public static void main(String[] args) {

    }

    public boolean match(String pattern, String str) {
        if (pattern == null || pattern.length() == 0) {
            return false;
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        Map<Character, String> reflect = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            boolean havingKey = reflect.containsKey(pattern.charAt(i));
            if (havingKey) {
                String value = reflect.get(pattern.charAt(i));
                if (!value.equals(strs[i])) {
                    return false;
                }
            } else {
                boolean havingValue = reflect.containsValue(strs[i]);
                if (havingValue) {
                    return false;
                }
                reflect.put(pattern.charAt(i), strs[i]);
            }

        }
        return true;
    }

}
