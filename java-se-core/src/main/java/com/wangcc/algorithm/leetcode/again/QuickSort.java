package com.wangcc.algorithm.leetcode.again;

/**
 * @Author: BryantCong
 * @Date: 2019/10/31 13:42
 * @Description:
 */
public class QuickSort {


    public void quickSort(int[] arr) {

    }

    public void quickSort(int start, int end, int[] arr) {
        if (start < end) {
            int pos = pos(start, end, arr);
            quickSort(start, pos - 1, arr);
            quickSort(pos + 1, end, arr);
        }
    }

    public int pos(int start, int end, int[] arr) {
        int temp = arr[start];
        while (start < end) {
            while (start < end && temp < arr[end]) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && temp > arr[start]) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }
}
