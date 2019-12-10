package com.wangcc.algorithm.leetcode.again;

/**
 * @Author: BryantCong
 * @Date: 2019/10/31 13:31
 * @Description:
 */
public class DubbleSort {

    public void dubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean order = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    MySort.swap(arr, j + 1, j);
                    order = false;
                }
            }
            if (order) {
                break;
            }
        }
    }
}

