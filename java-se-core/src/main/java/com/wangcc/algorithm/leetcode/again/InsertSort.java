package com.wangcc.algorithm.leetcode.again;

/**
 * @Author: BryantCong
 * @Date: 2019/10/31 13:27
 * @Description:
 */
public class InsertSort {

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                MySort.swap(arr,j,j-1);
                j--;
            }
        }
    }
}
