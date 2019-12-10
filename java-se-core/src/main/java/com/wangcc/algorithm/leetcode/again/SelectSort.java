package com.wangcc.algorithm.leetcode.again;

/**
 * @Author: BryantCong
 * @Date: 2019/10/31 13:33
 * @Description:
 */
public class SelectSort {

    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; i < arr.length; i++) {
                if (arr[min] > arr[j]) {
                    min = i;
                }
            }
            if (min != i) {
                MySort.swap(arr, i, min);
            }
        }
    }
}
