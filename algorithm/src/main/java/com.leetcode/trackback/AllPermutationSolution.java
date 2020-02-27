package com.leetcode.trackback;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2019/12/12 10:55
 * @Description: 全排列问题
 * <p>
 * 回溯算法
 * <p>
 * <p>
 * 判断是否完成了一次路径的探索，完成则终止，返回
 * 在所有可选择的列表中进行选择，
 * 排除掉不符合条件的选择，
 * 将当前选择加入到路径中
 * 将当前选择从选择列表中移除
 * 进行回溯
 * 回溯完成返回后，将当前选择从路径中移除，
 * 将当前选择重新加入到选择列表中
 */
public class AllPermutationSolution {

    public List<List<Integer>> allPermutation(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        allPermutation(nums, new Stack<Integer>(), used, res);
        return res;
    }

    private void allPermutation(int[] nums, Stack<Integer> track, boolean[] used, List<List<Integer>> res) {
        //终止条件
        if (nums.length == track.size()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //筛选掉不符合条件的选择
            //TODO 考虑元素重复的情况，那么需要将元素排序
            // 只要是顺序排序的，都视为不符合要求，只留下一个完全倒序的
//            if (used[i] || (i > 0 && used[i - 1] && (nums[i - 1] == nums[i]))) {
//                continue;
//            }
            if (used[i]) {
                continue;
            }
            //将当前选择加入到路径中
            //将当前选择从选择列表中移除
            used[i] = true;
            track.push(nums[i]);
            allPermutation(nums, track, used, res);
            //将当前选择重新放入选择列表中
            used[i] = false;
            //将其从路径中移除
            track.pop();

        }
    }
}
