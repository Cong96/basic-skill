package com.leetcode.twopointer.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2020/2/27 14:56
 * @Description: * @Description: 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * * <p>
 * * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * * <p>
 * *  
 * * <p>
 * * 示例 1：
 * * <p>
 * * 输入：
 * * s = "barfoothefoobarman",
 * * words = ["foo","bar"]
 * * 输出：[0,9]
 * * 解释：
 * * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * * 输出的顺序不重要, [9,0] 也是有效答案。
 * * 示例 2：
 * * <p>
 * * 输入：
 * * s = "wordgoodgoodgoodbestword",
 * * words = ["word","good","best","word"]
 * * 输出：[]
 * * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubStringSolution {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return null;
        }
        //提取重点，连续子串，联想到滑动窗口
        //还有一个重要条件，那就是长度相等的单词
        Map<String, Integer> matchMap = new HashMap<>();
        for (String word : words) {
            matchMap.put(word, matchMap.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> windowsMap = new HashMap<>();
        int wordLength = words[0].length();
        int wordNum = words.length;
        //这里有一个需要特殊处理的地方，那就是字符串长度不一定是wordLength的倍数
        int length = s.length();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < wordLength; i++) {
            int right = i;
            int left = i;
            int match = 0;
            while (right <= length - wordLength) {
                String rightStr = s.substring(right, right + wordLength);
                if (matchMap.containsKey(rightStr)) {
                    windowsMap.put(rightStr, windowsMap.getOrDefault(rightStr, 0) + 1);
                    if (windowsMap.get(rightStr).equals(matchMap.get(rightStr))) {
                        match++;
                    }
                }
                while (match == matchMap.size()) {
                    if (right - left + wordLength == wordLength * wordNum) {
                        res.add(left);
                    }
                    String leftStr = s.substring(left, left + wordLength);
                    if (matchMap.containsKey(leftStr)) {
                        windowsMap.put(leftStr, windowsMap.get(leftStr) - 1);
                        if (windowsMap.get(leftStr) < matchMap.get(leftStr)) {
                            match--;
                        }
                    }
                    left += wordLength;
                }

                right += wordLength;
            }

            // 清空窗口，进行下一次遍历 注意清理
            windowsMap.clear();
        }
        return res;
    }

}