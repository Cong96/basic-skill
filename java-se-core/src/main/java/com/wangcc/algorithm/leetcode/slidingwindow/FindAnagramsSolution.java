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
 * <p>
 * 滑动窗口算法的思路是这样：
 * <p>
 * 1、我们在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，把索引闭区间 [left, right] 称为一个「窗口」。
 * <p>
 * 2、我们先不断地增加 right 指针扩大窗口 [left, right]，直到窗口中的字符串符合要求（包含了 T 中的所有字符）。
 * <p>
 * 3、此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right]，直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。同时，每次增加 left，我们都要更新一轮结果。
 * <p>
 * 4、重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。
 * <p>
 * 作者：labuladong
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
            while (match == needs.size()) {
                //不同的是这一块的处理，其他关于滑动窗口的，都可以使用该模板解决问题
                if (right - left + 1 == p.length()) {
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
            right++;

        }

        return result;
    }
}
