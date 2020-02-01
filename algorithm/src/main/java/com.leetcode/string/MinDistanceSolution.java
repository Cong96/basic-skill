package com.leetcode.string;

/**
 * @ClassName MinDistanceSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 16:51
 * @Version V1.0
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 * 说明:
 * <p>
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MinDistanceSolution {

    public int minDistance(String word1, String word2) {
        //TODO 没有考虑顺序
//        Map<Character, Integer> word1Map = new HashMap<>();
//        for (char c : word1.toCharArray()) {
//            word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);
//        }
//
//        Map<Character, Integer> word2Map = new HashMap<>();
//        for (char c : word2.toCharArray()) {
//            word2Map.put(c, word2Map.getOrDefault(c, 0) + 1);
//        }
//        int count = 0;
//        for (Character c : word1Map.keySet()) {
//            if (word2Map.containsKey(c)) {
//                int diffCount = Math.abs(word1Map.get(c) - word2Map.get(c));
//                count += diffCount;
//            } else {
//                count += word1Map.get(c);
//            }
//        }
//        for (Character c : word2Map.keySet()) {
//            if (!word1Map.containsKey(c)) {
//                count += word2Map.get(c);
//            }
//        }
//        return count;

        //找最长公共子串
        //要使得删除的字符最少，只需找到两字符串的最长公共子串。
        //动态规划
        int s1Length = word1.length();
        int s2Length = word2.length();
        //s1前i个字符串和s2前j个字符串的最长公共子串
        int dp[][] = new int[s1Length + 1][s2Length + 1];
        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    /***
                     *
                     * 字符s1[i−1] 和s2[j−1] 不匹配，这种情况下我们不能直接增加已匹配子序列的长度，但我们可以将之前已经求解过的最长公共子序列的长度作为当前最长公共子序列的长度。但是我们应该选择哪一个呢？
                     * 事实上此时我们有 2 种选择。我们可以删除 s1 或者 s2的最后一个字符然后将对应的 dp 数组的值作比较，
                     * 也就是取 dp[i−1][j] 和 dp[i][j-1]的较大值。
                     *
                     * 作者：LeetCode
                     * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings/solution/liang-ge-zi-fu-chuan-de-shan-chu-cao-zuo-by-leetco/
                     * 来源：力扣（LeetCode）
                     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
                     * */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return s1Length + s2Length - 2 * dp[s1Length][s2Length];
    }

}
