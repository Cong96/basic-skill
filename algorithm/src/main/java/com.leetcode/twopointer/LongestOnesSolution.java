package com.leetcode.twopointer;

/**
 * @ClassName LongestOnesSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 17:10
 * @Version V1.0
 * <p>
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LongestOnesSolution {
    public static void main(String[] args) {
        LongestOnesSolution longestOnesSolution = new LongestOnesSolution();
        int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};

        int res = longestOnesSolution.longestOnes(nums, 2);
        System.out.println(res);
    }

    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int length = A.length;
        int right = 0;
        int left = 0;
        int count = 0;
        int max = 0;
        //滑动窗口的大小
        while (right < length) {
            if (A[right] == 1) {
                count++;
            }
            //处理掉不满足条件的情况
            while (right - left + 1 > K + count) {
                if (A[left] == 1) {
                    count--;
                }
                left++;
            }
            //得到的是满足条件的情况
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
