package com.wangcc.algorithm.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/10/24 22:47
 * @Description: 快速排序之三数取中法
 */
public class MyQuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4, 5, 7, 8, 6};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    //从左边寻找大于枢纽值的数，从右边寻找小于枢纽值的数   pivot

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            dealPivot(arr, left, right);
            int pivot = right - 1;
            int i = left;  //从左寻找大于枢纽值的数
            int j = right - 1;//从右边寻找小于枢纽值的数
            while (true) {
                while (arr[++i] < arr[pivot]) {

                }
                while (j > left && arr[--j] > arr[pivot]) {

                }
                if (i < j) {
                    MySort.swap(arr, i, j);
                } else {
                    break;
                }
            }
            //如果i不小于right，就代表pivot前面全部有序
            if (i < right) {
                MySort.swap(arr, i, right - 1);
            }
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

    private static void dealPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        //将三个节点进行排序

        if (arr[left] > arr[mid]) {
            MySort.swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            MySort.swap(arr, left, right);
        }
        if (arr[mid] > arr[right]) {
            MySort.swap(arr, mid, right);
        }
        MySort.swap(arr, right - 1, mid);

    }

}
