package com.datastructure.sort;

/**
 * @Author: BryantCong
 * @Date: 2019/12/10 18:04
 * @Description:
 */
public class MySortUtil {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
