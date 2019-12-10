package com.wangcc.algorithm.leetcode.again;

/**
 * @Author: BryantCong
 * @Date: 2019/10/31 11:51
 * @Description: 动态规划
 */
public class PeachSolution {

    public static void main(String[] args) {
        PeachSolution solution = new PeachSolution();
        int[] peaches = new int[]{2, 5, 6, 4, 8, 7};
        System.out.println(solution.pick(peaches));
    }

    public int pick(int[] peaches) {

        int dp[] = new int[peaches.length];
        dp[0] = 1;
        for (int i = 1; i < peaches.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (peaches[j] <= peaches[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 1;
        for (int num : dp) {
            max = num > max ? num : max;
        }
        return max;
    }

}
