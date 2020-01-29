package com.leetcode.twopointer;

/**
 * @ClassName MaxAreaSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 10:56
 * @Version V1.0
 *
 *
 * 双指针
 **/
public class MaxAreaSolution {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {

        int left=0;
        int right=height.length-1;
        int maxArea=0;
        while(left<right){
            maxArea=Math.max(Math.min(height[left],height[right])*(right-left),maxArea);
            if(height[right]>height[left]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }


}
