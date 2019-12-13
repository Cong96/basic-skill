package com.leetcode.dp;

import java.util.Arrays;

/**
 * @Author: BryantCong
 * @Date: 2019/12/13 11:45
 * @Description: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 这个状态转移方程比较容易得到
 * <p>
 * 寻找最小的dp[amount-coin]+1
 */
public class CoinChangeSolution {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 9;
        CoinChangeSolution coinChangeSolution = new CoinChangeSolution();
        System.out.println(coinChangeSolution.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                if (dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }
        return dp[amount] == amount ? -1 : dp[amount];
    }
}
