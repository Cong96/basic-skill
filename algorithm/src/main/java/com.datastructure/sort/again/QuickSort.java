package com.datastructure.sort.again;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 19:24
 * @Description:
 */
public class QuickSort {

    public static void main(String[] args) {

    }

    public void quickSort(int[] arr) {

    }

    public int pos(int[] arr, int left, int right) {
        //基准值
        int base = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= base) {
                right--;
            }
            arr[right] = arr[left];
            while (left < right && arr[left] <= base) {
                left++;
            }
            arr[left]=arr[right];
        }
        arr[left] = base;
        return left;
    }
}
