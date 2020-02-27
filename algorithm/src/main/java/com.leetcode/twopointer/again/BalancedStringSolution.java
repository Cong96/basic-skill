package com.leetcode.twopointer.again;

/**
 * @Author: BryantCong
 * @Date: 2020/2/27 09:49
 * @Description: * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * * <p>
 * * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * * <p>
 * *  
 * * <p>
 * * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * * <p>
 * * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * * <p>
 * * 请返回待替换子串的最小可能长度。
 * * <p>
 * * 如果原字符串自身就是一个平衡字符串，则返回 0。
 */
public class BalancedStringSolution {


    public int balancedString(String s) {
        //这也是使用滑动窗口可以解决的问题
        //但是这个和我们熟悉的滑动窗口的解决有点小小的不同。
        //这里要求的是待替换子串的最小长度
        //滑动窗口，之前我们都是让窗口内元素的成为我们要符合的条件，但是这次不同，这次是我要让窗口外的成为我们要符合的条件
        int[] count = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            count[s.charAt(i) - 'A'] += 1;
        }
        //base case
        if (check(count, length)) {
            return 0;
        }
        //twopointer
        int left = 0;
        int right = 0;
        int res = length;
        while (right < length) {
            //窗口往右扩
            //窗口外的就-1
            count[s.charAt(right) - 'A'] -= 1;
            //如果一旦符合条件了，那么我们就尝试缩小这个窗口，找到最小的窗口
            while (check(count, length)) {
                //比较条件一定是在内层while循环里面
                res = Math.min(res, right - left + 1);
                count[s.charAt(left) - 'A'] += 1;
                left++;
            }
            right++;
        }
        return res;
    }

    //如果窗口外的都符合每个元素都在1/4以内，那么就没问题了
    private boolean check(int[] count, int length) {
        return count['Q' - 'A'] <= length / 4 && count['W' - 'A'] <= length / 4 && count['E' - 'A'] <= length / 4 && count['R' - 'A'] <= length / 4;
    }
}