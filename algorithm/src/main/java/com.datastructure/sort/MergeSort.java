package com.datastructure.sort;

/**
 * @Author: BryantCong
 * @Date: 2019/12/10 18:18
 * @Description: 归并排序
 * <p>
 * 归并排序的核心是让局部先有序
 * 不断的去合并局部有序的子序列
 */
public class MergeSort {
    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

    }

    //需要一个临时数组来存放本次排好的局部子序列
    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            int i = left;
            int m = mid;
            int j = mid + 1;
            int n = right;
            int k = 0;
            while (i <= m && j <= n) {
                //如果不是顺序的
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
                arr[left + h] = temp[h];
            }
        }
    }
}
