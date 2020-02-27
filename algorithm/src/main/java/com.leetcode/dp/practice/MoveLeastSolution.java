package com.leetcode.dp.practice;

import java.util.Arrays;

/**
 * @Author: BryantCong
 * @Date: 2020/2/25 15:31
 * @Description:
 */
public class MoveLeastSolution {
    public static void main(String[] args) {

    }

    public int moveLeast(int[] moves) {
        int[] dp = new int[moves.length];
        Arrays.fill(dp, moves.length);
        dp[0] = 0;
        for (int right = 1; right < moves.length; right++) {
            for (int left = 0; left < right; left++) {
                if (moves[left] + left >= right) {
                    if (dp[right] > dp[left] + 1) {
                        dp[right] = dp[left] + 1;
                    }
                }
            }
        }
        return dp[moves.length-1];
    }
}