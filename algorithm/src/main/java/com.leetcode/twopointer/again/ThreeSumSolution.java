package com.leetcode.twopointer.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ThreeSumSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 13:29
 * @Version V1.0
 **/
public class ThreeSumSolution {

    public static void main(String[] args) {

    }

    public List<List<Integer>>  threeSum(int[] nums){
        List<List<Integer>>  res=new ArrayList<>();

        if(nums==null||nums.length<3){
            return null;
        }
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=len-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{

                    right--;
                }
            }
        }
        return res;
    }
}
