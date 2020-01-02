package com.leetcode.dp.again;

import java.util.Arrays;

/**
 * @Author: BryantCong
 * @Date: 2020/1/1 21:08
 * @Description: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * <p>
 * 如果是为了面试，其实有些时候看到最小最多这些词汇的时候，其实就可以很自然的想到动态规划
 */
public class CoinChangeSolution {

    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (amount - coin < 0) {
                    continue;
                }
                //需找最小的  min(amount-coin)+1
                if (dp[i] > dp[amount - coin] + 1) {
                    dp[i] = dp[amount - coin] + 1;
                }
            }
        }
        return dp[amount] == amount ? -1 : dp[amount];
    }
}
