package com.ali.prepare.dp;

import java.util.Arrays;

/**
 * @Author: BryantCong
 * @Date: 2020/1/4 18:28
 * @Description:
 */
public class JumpSolution {
    public static void main(String[] args) {
        //     int[] nums = new int[]{3, 2, 1, 0, 4};
        int[] nums = new int[]{2, 3, 1, 1, 4};

        JumpSolution jumpSolution = new JumpSolution();
        System.out.println(jumpSolution.canJump(nums));
        System.out.println(jumpSolution.canJumpDp(nums));
    }

    public boolean canJump(int[] nums) {

        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (lastPos <= i + nums[i]) {
                lastPos = i;
            }
        }


        return lastPos == 0;
    }

    public boolean canJumpDp(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length <= 1) {
            return true;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, nums.length);
        dp[0] = 0;
        for (int right = 1; right < nums.length; right++) {
            for (int left = 0; left < right; left++) {
                if (left + nums[left] >= right && dp[right] > dp[left] + 1) {
                    dp[right] = dp[left] + 1;
                }
            }
        }

        return dp[nums.length - 1] == nums.length ? false : true;
    }

}
