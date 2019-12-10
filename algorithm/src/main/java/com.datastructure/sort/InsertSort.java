package com.datastructure.sort;

/**
 * @Author: BryantCong
 * @Date: 2019/12/10 17:58
 * @Description: 将元素直接插入到一个已排好序的集合
 */
public class InsertSort {

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            //从排好序的序列的尾部往前遍历，直到遇到第一个不小于他的值
            while (j > 0 && arr[j] < arr[j - 1]) {
                MySortUtil.swap(arr, j, j - 1);
                j--;
            }
        }
    }
}
