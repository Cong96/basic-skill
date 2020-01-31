package com.leetcode.twopointer;

/**
 * @ClassName BalancedStringSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 14:41
 * @Version V1.0
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * <p>
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * <p>
 *  
 * <p>
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * <p>
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * <p>
 * 请返回待替换子串的最小可能长度。
 * <p>
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-the-substring-for-balanced-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。\
 * 示例 1：
 * <p>
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * 示例 2：
 * <p>
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * 示例 3：
 * <p>
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。
 * 示例 4：
 * <p>
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s.length 是 4 的倍数
 * s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-the-substring-for-balanced-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class BalancedStringSolution {
    public int balancedString(String s) {
        int[] count = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            count[s.charAt(i) - 'A'] += 1;
        }
        if (check(count, length)) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int res = length;
        while (right < length) {
            count[s.charAt(right) - 'A'] -= 1;
            //窗口外的字符串保持符合条件
            //这里的条件是left<length为什么呢
            while (check(count, length)) {
                res = Math.min(res, right - left + 1);
                count[s.charAt(left) - 'A'] += 1;
                left++;
            }
            right++;
        }
        return res;
    }

    private boolean check(int[] count, int length) {
        return count['Q' - 'A'] <= length / 4 && count['W' - 'A'] <= length / 4 && count['E' - 'A'] <= length / 4 && count['R' - 'A'] <= length / 4;
    }

}
