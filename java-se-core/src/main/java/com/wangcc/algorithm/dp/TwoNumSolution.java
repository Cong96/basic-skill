package com.wangcc.algorithm.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/10/28 15:43
 * @Description:
 */
public class TwoNumSolution {


    public static void main(String[] args) {

        int[] arr = new int[]{2, 6, 7, 8, 9, 10};
        int [] result=towNumSimple(arr,11);
        for(int i:result){
            System.out.println(i);
        }
    }

    public static int[] towNumSimple(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; i < arr.length; j++) {
                if (arr[j] == target - arr[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
