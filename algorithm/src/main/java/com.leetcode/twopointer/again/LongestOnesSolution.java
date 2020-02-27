package com.leetcode.twopointer.again;

/**
 * @Author: BryantCong
 * @Date: 2020/2/27 10:40
 * @Description: * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * * <p>
 * * 返回仅包含 1 的最长（连续）子数组的长度。
 * * <p>
 * *  
 * * <p>
 * * 示例 1：
 * * <p>
 * * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * * 输出：6
 * * 解释：
 * * [1,1,1,0,0,1,1,1,1,1,1]
 * * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * * 示例 2：
 * * <p>
 * * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * * 输出：10
 * * 解释：
 * * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestOnesSolution {

    public int longestOnes(int[] A, int K) {
        //依旧使用滑动窗口
        int left = 0;
        int right = 0;
        int length = A.length;
        int count = 0;
        int res = 0;
        while (right < length) {
            if (A[right] == 1) {
                count++;
            }
            //while循环干掉不符合条件的，意味着结果要在while循环处理完之后得到
            while (right - left + 1 > count + K) {
                if (A[left] == 1) {
                    count--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}