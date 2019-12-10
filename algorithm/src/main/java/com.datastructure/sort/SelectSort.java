package com.datastructure.sort;

/**
 * @Author: BryantCong
 * @Date: 2019/12/10 17:58
 * @Description: 每次选择一个最大（或者最小）放到数组的对应位置，每次都把一个元素放置到应放置的位置
 */
public class SelectSort {

    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                MySortUtil.swap(arr,min,i);
            }
        }
    }
}
