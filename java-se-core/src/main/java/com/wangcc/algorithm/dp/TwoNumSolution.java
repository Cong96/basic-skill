package com.wangcc.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2019/10/28 15:43
 * @Description:
 */
public class TwoNumSolution {


    public static void main(String[] args) {

        int[] arr = new int[]{2, 6, 7, 8, 9, 10};
        int[] result = twoNum(arr, 11);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoNum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    public static int[] towNumSimple(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; i < arr.length; j++) {
                if (arr[j] == target - arr[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
