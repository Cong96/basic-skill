package com.datastructure.sort.again;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 16:43
 * @Description: 希尔排序  可以理解为升级版的插入排序
 */
public class ShellSort {
    public static void main(String[] args) {

    }

    public void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i = i + gap) {
                int j = i;
                while (j > 0 && arr[j] < arr[j - gap]) {
                    SortUtil.swap(arr, j, j - gap);
                    j = j - gap;
                }
            }
        }
    }
}
