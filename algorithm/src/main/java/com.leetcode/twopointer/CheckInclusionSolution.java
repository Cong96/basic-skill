package com.leetcode.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CheckInclusionSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 14:43
 * @Version V1.0
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CheckInclusionSolution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> matchMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            matchMap.put(c, matchMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windowsMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = s2.length();
        int match = 0;
        while (right < length) {
            char rightChar = s2.charAt(right);
            if (matchMap.containsKey(rightChar)) {
                windowsMap.put(rightChar, windowsMap.getOrDefault(rightChar, 0) + 1);
                if (windowsMap.get(rightChar).equals(matchMap.get(rightChar))) {
                    match++;
                }
            }
            while (matchMap.size() == match) {
                if (right - left + 1 == s1.length()) {
                    return true;
                }
                char leftChar = s2.charAt(left);
                if (matchMap.containsKey(leftChar)) {
                    windowsMap.put(leftChar, windowsMap.get(leftChar) - 1);
                    if (windowsMap.get(leftChar) < matchMap.get(leftChar)) {
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
