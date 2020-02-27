package com.leetcode.dp.practice;

/**
 * @Author: BryantCong
 * @Date: 2020/2/25 14:50
 * @Description: 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * <p>
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化
 */
public class PredictTheWinnerSolution {


    public boolean predictTheWinner(int[] nums) {
        //如何建立状态转移方程
        int n = nums.length;
        //dp[i][j] 表示当剩下的数为 nums[i .. j] 时，当前操作的选手（注意，不一定是先手）与另一位选手最多的分数差
        //选择num[i]则剩下nums[i+1..j]    或者选择num[j]  留下nums[i..j-1]
        //那么dp状态转移方程dp[i][j]=max(nums[i]-dp[i+1][j],nums[j]-dp[i,j-1])
        //那么问题就转变为如何遍历才可以利用到之前的dp
        //状态转移方程已经给出了答案，我们要利用i+1,那么i肯定是倒序遍历的。要利用j-1,那么j肯定是顺序
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int left = n - 1; left >= 0; left--) {
            for (int right = left + 1; right < n; right++) {
                dp[left][right] = Math.max(nums[left] - dp[left + 1][right], nums[right] - dp[left][right - 1]);
            }
        }

        return dp[0][n - 1] >= 0;
    }
}