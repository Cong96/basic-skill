package com.leetcode.twopointer;

import java.util.Arrays;

/**
 * @ClassName ThreeSumClosestSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 13:50
 * @Version V1.0
 **/
public class ThreeSumClosestSolution {
    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=nums[0]+nums[1]+nums[2];
        int len=nums.length;
        for(int i=0;i<len;i++){
            int left=i+1;
            int right=len-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<Math.abs(res-target)){
                    res=sum;
                }
                if(sum<target){
                    left++;
                }
                else if(sum>target){
                    right--;
                }
                else
                    return res;
            }
        }
        return res;
    }
}
