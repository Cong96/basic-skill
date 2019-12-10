package com.wangcc.algorithm.leetcode.again;

/**
 * @Author: BryantCong
 * @Date: 2019/10/31 13:46
 * @Description:
 */
public class HeapSort {

    public void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        int j = arr.length - 1;
        while (j > 0) {
            MySort.swap(arr, 0, j);
            adjustHeap(arr, 0, j);
            j--;
        }

    }

    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k) {
            if (k < length - 1 && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;
    }
}
