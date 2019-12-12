package com.datastructure.sort;

/**
 * @Author: BryantCong
 * @Date: 2019/12/10 18:11
 * @Description: 希尔排序   插入排序的升级版
 * <p>
 * TODO 详细解析
 */
public class ShellSort {

    public void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j >= gap && arr[j] < arr[j - gap]) {
                    MySortUtil.swap(arr, j, j - gap);
                    j = j - gap;
                }
            }
            gap = gap / 2;
        }
    }
}
