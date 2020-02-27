package com.leetcode.dp.practice;

import java.util.Arrays;

/**
 * @Author: BryantCong
 * @Date: 2020/2/25 14:20
 * @Description: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class CoinChangeSolution {

    public static void main(String[] args) {

    }


    //如果组成不了，那么就返回-1
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        //先初始化数据
        Arrays.fill(dp, amount + 1);
        dp[0]=0;
        for(int coin:coins){
            if(amount-coin<0){
                continue;
            }
            if(dp[amount]>dp[amount-coin]+1){
                dp[amount]=dp[amount-coin]+1;
            }
        }

        return dp[amount]==amount+1?-1:dp[amount];

    }

}