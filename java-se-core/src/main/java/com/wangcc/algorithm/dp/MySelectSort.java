package com.wangcc.algorithm.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/10/24 21:44
 * @Description:
 */
public class MySelectSort {


    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4, 5, 7, 8, 6};
        selectSort(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }

    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                MySort.swap(a, min, i);
            }
        }
    }
}
