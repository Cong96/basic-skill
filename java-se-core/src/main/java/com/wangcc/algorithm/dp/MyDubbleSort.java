package com.wangcc.algorithm.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/10/24 21:48
 * @Description:
 */
public class MyDubbleSort {

    //每次对相邻的元素进行两两比较，顺序相反则进行交换，这样，每一趟会将最小或最大的元素“浮”到顶端，最终达到完全有序
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4, 5, 7,9, 8, 6};
        dubbleSort(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }
    public static void dubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    MySort.swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

}
