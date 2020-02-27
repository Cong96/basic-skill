package com.leetcode.dp.practice;

/**
 * @Author: BryantCong
 * @Date: 2020/2/25 10:24小猴子想摘桃子，但是有一些条件需要遵守，小猴子只能沿着下山的方向走，不能回头，每颗树最多摘一个，而且一旦摘了一棵树的桃子，就不能再摘比这棵树结的桃子少的树上的桃子。那么小猴子最多能摘到几颗桃子呢？
 */

public class PeachSolution {

    public static void main(String[] args) {
        int[] peaches = new int[]{2, 5, 1, 8, 4, 6, 7};
    }

    public int pick(int[] peaches) {
        //首先创建dp数组
        int[] dp = new int[peaches.length];
        //dp记录着什么。记录着当index i这哥位置的桃子被选择的时候，最多能摘几颗
        dp[0] = 1;
        for (int right = 1; right < peaches.length; right++) {
            //假设所有的前面的桃子都比我大，那么当到我这的时候，最坏的情况下是1，就是只选我，但是一旦有任何一个比我小的，那么就会改变了
            dp[right] = 1;
            for (int left = 0; left < right; left++) {
                //TODO
                if (peaches[right] >= peaches[left] && dp[right] < dp[left] + 1) {
                    dp[right] = dp[left] + 1;
                }
            }
        }

        int max = 1;
        for (int i : dp) {
            max = max < i ? i : max;
        }
        return max;
    }
}