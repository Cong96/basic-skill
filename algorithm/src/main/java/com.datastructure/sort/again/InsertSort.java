package com.datastructure.sort.again;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 15:22
 * @Description: 插入排序，顾名思义，将元素插入到已经有序的序列中他该在的位置
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 4, 5, 7, 3, 6};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                SortUtil.swap(nums, j, j - 1);
                j--;
            }
        }
    }
}
