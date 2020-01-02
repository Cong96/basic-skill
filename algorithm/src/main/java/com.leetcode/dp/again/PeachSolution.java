package com.leetcode.dp.again;

/**
 * @Author: BryantCong
 * @Date: 2020/1/1 20:38
 * @Description: 小猴子下山，沿着下山的路有一排桃树，每棵树都结了一些桃子。小猴子想摘桃子，但是有一些条件需要遵守，小猴子只能沿着下山的方向走，不能回头，每颗树最多摘一个，而且一旦摘了一棵树的桃子，就不能再摘比这棵树结的桃子少的树上的桃子。那么小猴子最多能摘到几颗桃子呢？
 */
public class PeachSolution {
    public static void main(String[] args) {
        int[] peaches = new int[]{2, 5, 1, 8, 4, 4, 6, 7};

        PeachSolution peachSolution = new PeachSolution();
        System.out.println(peachSolution.pick(peaches));
    }

    public int pick(int[] peaches) {
        //使用动态规划，每个位置能够摘到的最多的桃子数，为之前位置桃子数不大于当前位置的+1的最大值
        //每一位要么是不被使用，要么是被使用，我们可以看看每个位置被使用时他的最大值
        //我们在求解后面的最大值的时候，可以看之前位置桃子数不大于当前位置的+1的最大值
        //这样就有了我们的状态转移方程
        int dp[] = new int[peaches.length];

        dp[0] = 1;
        for (int right = 1; right < peaches.length; right++) {
            //设置默认值，默认之前的元素都不小于他，那么
            dp[right] = 1;
            for (int left = 0; left < right; left++) {
                if (peaches[left] <= peaches[right] && dp[right] < dp[left] + 1) {
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
