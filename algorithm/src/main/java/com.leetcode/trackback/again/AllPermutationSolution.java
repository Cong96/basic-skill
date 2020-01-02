package com.leetcode.trackback.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2020/1/1 21:51
 * @Description:
 */
public class AllPermutationSolution {

    public static void main(String[] args) {

    }

    public List<List<Integer>> allPermutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        allPermutation(nums, new Stack<>(), used, result);
        return result;
    }

    public static void allPermutation(int[] nums, Stack<Integer> track, boolean[] used, List<List<Integer>> result) {
        if (nums.length == track.size()) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //排除掉不符合条件的选择
            //如果是有重复元素的话，那么先需要使用排序列表有序
            //然后只保留倒序或者顺序就好
            if (used[i] || (i > 0 && used[i - 1] && nums[i - 1] == nums[i])) {
                continue;
            }
            //将当前选择从选择列表中剔除
            used[i] = true;
            track.push(nums[i]);
            allPermutation(nums, track, used, result);
            //移出路径
            track.pop();
            //加入到选择队列
            used[i] = false;


        }

    }
}
