package com.wangcc.algorithm.leetcode.slidingwindow;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2019/12/2 10:27
 * @Description: 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAnagramsSolution {

    public static void main(String[] args) {
        FindAnagramsSolution findAnagramsSolution = new FindAnagramsSolution();
        List<Integer> result = findAnagramsSolution.findAnagrams("cbaebabacd", "abc");
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = Lists.newArrayList();
        Map<Character, Integer> needs = Maps.newHashMap();
        Map<Character, Integer> windows = Maps.newHashMap();
        for (char c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int right = 0;
        int match = 0;
        int left = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                windows.put(c1, windows.getOrDefault(c1, 0) + 1);
                if (windows.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                //不同的是这一块的处理，其他关于滑动窗口的，都可以使用该模板解决问题
                if (right - left == p.length()) {
                    result.add(left);
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

        return result;
    }
}
