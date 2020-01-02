package com.datastructure.sort.again;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 15:26
 * @Description:
 */
public class SortUtil {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
