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
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int left, int right) {
        //边界:无序区间为0
        if (left < right) {
            //确定基准元素的位置，直到没有无序区域
            int pos = pos(arr, left, right);
            pos(arr, left, pos - 1);
            pos(arr, pos + 1, right);
        }
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
            arr[left] = arr[right];
        }
        arr[left] = base;
        return left;
    }
}
