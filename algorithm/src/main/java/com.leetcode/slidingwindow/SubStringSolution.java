package com.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2020/1/5 21:07
 * @Description: 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubStringSolution {


    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        SubStringSolution subStringSolution = new SubStringSolution();
        List<Integer> res = subStringSolution.findSubstring(s, words);
        for (Integer i : res) {
            System.out.println(i);
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return null;
        }
        Map<String, Integer> needsMap = new HashMap<>();
        Map<String, Integer> windowsMap = new HashMap<>();
        for (String word : words) {
            needsMap.put(word, needsMap.getOrDefault(word, 0) + 1);
        }
        int wordArrayLength = words.length;
        int oneWordLength = words[0].length();
        //因为字符串的长度并不一定刚好是单词长度的倍数，所以需要考虑到所有可以组成单词的情况
        for (int i = 0; i < oneWordLength; i++) {
            int left = i, right = i;
            int match = 0;
            while (right + oneWordLength <= s.length()) {
                String rightStr = s.substring(right, right + oneWordLength);
                if (needsMap.containsKey(rightStr)) {
                    windowsMap.put(rightStr, windowsMap.getOrDefault(rightStr, 0) + 1);
                    if (needsMap.get(rightStr).equals(windowsMap.get(rightStr))) {
                        match++;
                    }
                }

                while (match == needsMap.size()) {
                    if ((right + oneWordLength - left) / oneWordLength == wordArrayLength) {
                        res.add(left);
                    }
                    String leftStr = s.substring(left, left + oneWordLength);
                    if (needsMap.containsKey(leftStr)) {
                        windowsMap.put(leftStr, windowsMap.get(leftStr) - 1);
                        if (needsMap.get(leftStr) > windowsMap.get(leftStr)) {
                            match--;
                        }
                    }
                    left = left + oneWordLength;
                }
                right = right + oneWordLength;

            }

            // 清空窗口，进行下一次遍历
            windowsMap.clear();
        }
        return res;
    }

}
