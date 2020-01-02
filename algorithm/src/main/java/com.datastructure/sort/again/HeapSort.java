package com.datastructure.sort.again;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 17:22
 * @Description: 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9,1, 3, 2, 4, 5, 7, 3, 6};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustDown(arr, arr.length, i);
        }

        int j = arr.length - 1;
        while (j > 0) {
            SortUtil.swap(arr, j, 0);
            adjustDown(arr, j, 0);
            j--;

        }
    }

    public void adjustDown(int[] arr, int length, int i) {
        int temp = arr[i];
        for (int largest = 2 * i + 1; largest < length; largest = largest * 2 + 1) {
            if (largest<length-1&&arr[largest] < arr[largest + 1]) {
                largest = largest + 1;
            }
            if (temp < arr[largest]) {
                arr[i] = arr[largest];
                i = largest;
            } else {
                break;
            }
        }
        arr[i] = temp;

    }
}
