package com.datastructure.sort.again;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 19:24
 * @Description: 归并排序
 * 先是两两排序，然后4个排序，然后8个排序等等，，，，
 */
public class MergeSort {

    public static void main(String[] args) {

    }

    public void mergeSort(int[] arr) {

    }

    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (right + left) >> 1;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            int i = left;
            int m = mid;
            int j = mid + 1;
            int n = right;
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
                temp[k++] = arr[i++];
            }
            for (int h = 0; h < k; h++) {
                arr[left + h] = temp[h];
            }
        }
    }
}
