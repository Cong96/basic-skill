package com.wangcc.algorithm.leetcode.again;

/**
 * @Author: BryantCong
 * @Date: 2019/10/31 13:35
 * @Description:
 */
public class MergeSort {

    public void mergeSort(int[] arr) {
        int[] temp=new int[arr.length];
        mergeSort(0,arr.length-1,arr,temp);
    }

    public void mergeSort(int start, int end, int[] arr, int[] temp) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(start, mid, arr, temp);
            mergeSort(mid + 1, end, arr, temp);
            int i = start;
            int m = mid;
            int j = mid + 1;
            int n = end;
            int k = 0;
            while (i <= m && j <= n) {
                if (arr[i] > arr[j]) {
                    temp[k++] = arr[j++];
                } else {
                    temp[k++] = arr[i++];
                }
            }
            while (i <= m) {
                temp[k++] = arr[i++];
            }
            while (j <= n) {
                temp[k++] = arr[j++];
            }
            for (int h = 0; h < k; h++) {
                arr[start + h] = temp[h];
            }
        }
    }
}
