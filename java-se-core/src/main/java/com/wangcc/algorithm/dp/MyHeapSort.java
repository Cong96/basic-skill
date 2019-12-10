package com.wangcc.algorithm.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/10/24 22:08
 * @Description:
 */
public class MyHeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4, 5, 7, 8, 6,9};
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void heapSort(int[] arr) {
        //构建最大堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //调整堆，从右到左，做下到上
            adjustHeap(arr, i, arr.length);

        }
        //
        int j=arr.length-1;
        while(j>0){
            MySort.swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);
            j--;
        }
//        for(int j=arr.length-1;j>0;j--) {
//
//        }
    }

    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k) {
            if (k < length - 1 && arr[k] < arr[k + 1]) {   //如果右节点大于左节点，将k置为右节点
                k++;
            }
            if (arr[k] >temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }

        }
        arr[i] = temp;
    }

}
