package com.datastructure.sort.again;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 17:28
 * @Description:
 */
public class DubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9,1, 3, 2, 4, 5, 7, 3, 6};
        DubbleSort dubbleSort = new DubbleSort();
        dubbleSort.dubbleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void dubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean order = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtil.swap(arr, j, j + 1);
                    order = false;
                }
            }
            if (order) {
                break;
            }
        }
    }
}
