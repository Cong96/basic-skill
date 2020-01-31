package com.leetcode.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSumSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 14:13
 * @Version V1.0
 **/
public class TwoSumSolution {
    public static void main(String[] args) {

    }

    public int[] towSum(int[] nums,int target){
        //一次遍历解决
        Map<Integer,Integer> map=new HashMap<>();
        int len=nums.length;
        for(int i=0;i<len;i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{nums[i], map.get(nums[i])};
            }
            map.put(target - nums[i], nums[i]);
        }
        return null;
    }
}
