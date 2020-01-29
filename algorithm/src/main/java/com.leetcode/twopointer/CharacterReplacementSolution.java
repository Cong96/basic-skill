package com.leetcode.twopointer;

/**
 * @ClassName CharacterReplacementSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 11:12
 * @Version V1.0
 *
 *
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意:
 * 字符串长度 和 k 不会超过 104。
 *
 * 示例 1:
 *
 * 输入:
 * s = "ABAB", k = 2
 *
 * 输出:
 * 4
 *
 * 解释:
 * 用两个'A'替换为两个'B',反之亦然。
 * 示例 2:
 *
 * 输入:
 * s = "AABABBA", k = 1
 *
 * 输出:
 * 4
 *
 * 解释:
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/
public class CharacterReplacementSolution {
    public static void main(String[] args) {

    }

    public int characterReplacement(String s, int k) {
        int[] windows=new int[26];
        int left=0;
        int right=0;
        int length=s.length();
        int res=0;
        int maxLen=0;
        while(right<length){
            //将右边元素出现的次数加一
            windows[s.charAt(right)-'A']+=1;
            //找出现在元素出现的最大次数
            maxLen=Math.max(maxLen,windows[s.charAt(right)-'A']);
            //如果出现的最大次数加上k还是小于当前的窗口大小，那么就意味着不符合条件，我们要找到一个窗口
            //那么我就需要缩小窗口
            //我们要选择当前窗口下
            while(right-left+1>k+maxLen){
                windows[s.charAt(left)-'A']-=1;
                left++;
            }
            res=Math.max(res,right-left+1);
            right++;

        }
        return res;
    }
}
