package com.leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FourSumSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 14:18
 * @Version V1.0
 **/
public class FourSumSolution {
    public static void main(String[] args) {

    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null||nums.length<4){
            return result;
        }
        Arrays.sort(nums);
        int length=nums.length;
        for(int i=0;i<length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int min=nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(min>target){
                break;
            }
            int max=nums[i]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max<target){
                break;
            }
            for(int j=i+1;j<length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int left=j+1;
                int right=length-1;
                while(left<right){
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right&&nums[left]==nums[left++]){
                            left++;
                        }
                        while(left<right&&nums[right]==nums[right--]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(sum>target){
                        right--;
                    }
                    else{
                        left++;
                    }

                }
            }
        }
        return result;
    }
}
