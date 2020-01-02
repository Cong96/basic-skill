package com.datastructure.sort.again;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 15:42
 * @Description: 每次选出当前未排好序元素里面最小的元素，放入到有序队列的末端
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 4, 5, 7, 3, 6};
        SelectSort selectSort=new SelectSort();
        selectSort.selectSort(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }

    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                SortUtil.swap(arr, min, i);
            }
        }
    }

}
