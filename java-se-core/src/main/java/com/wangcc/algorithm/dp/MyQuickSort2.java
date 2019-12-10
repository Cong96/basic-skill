package com.wangcc.algorithm.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/10/25 21:48
 * @Description:
 */
public class MyQuickSort2 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4, 5, 7, 8, 6};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pos = pos(arr, left, right);
            quickSort(arr, left, pos - 1);
            quickSort(arr, pos + 1, right);
        }

    }

    private static int pos(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            //从右往左扫描，找到第一个比基准元素小的元素
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

}
