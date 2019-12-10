package com.wangcc.algorithm.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/10/24 21:59
 * @Description:
 */
public class MyInsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4, 5, 7, 8, 6};
        insertSort(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                MySort.swap(arr, j, j - 1);
                j--;
            }
        }
    }
}
