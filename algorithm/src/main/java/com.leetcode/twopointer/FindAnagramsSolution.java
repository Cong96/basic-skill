package com.leetcode.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FindAnagramsSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 16:57
 * @Version V1.0
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FindAnagramsSolution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> matchMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            matchMap.put(c, matchMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windowsMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = s.length();
        int match = 0;
        List<Integer> res = new ArrayList<>();
        while (right < length) {
            char rightChar = s.charAt(right);
            if (matchMap.containsKey(rightChar)) {
                windowsMap.put(rightChar, windowsMap.getOrDefault(rightChar, 0) + 1);
                if (matchMap.get(rightChar).equals(windowsMap.get(rightChar))) {
                    match++;
                }
            }
            while (matchMap.size() == match) {
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }
                char leftChar = s.charAt(left);
                if (matchMap.containsKey(leftChar)) {
                    windowsMap.put(leftChar, windowsMap.get(leftChar) - 1);
                    if (matchMap.get(leftChar) > windowsMap.get(leftChar)) {
                        match--;
                    }
                }
                left++;
            }
            right++;
        }

        return res;
    }

}
