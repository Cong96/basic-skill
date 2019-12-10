package com.wangcc.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2019/10/29 11:03
 * @Description: 全排列
 * <p>
 * “回溯搜索”算法即“深度优先遍历 + 状态重置 + 剪枝”
 *
 *
 * 在程序执行到上面这棵树的叶子结点的时候，此时递归到底，当前根结点到叶子结点走过的路径就构成一个全排列，把它加入结果集，我把这一步称之为“结算”。此时递归方法要返回了，对于方法返回以后，要做两件事情：
 *
 * （1）释放对最后一个数的占用；
 * （2）将最后一个数从当前选取的排列中弹出。
 *
 * 事实上在每一层的方法执行完毕，即将要返回的时候都需要这么做。这棵树上的每一个结点都会被访问 2 次，绕一圈回到第 1 次来到的那个结点，第 2 次回到结点的“状态”要和第 1 次来到这个结点时候的“状态”相同，这种程序员赋予程序的操作叫做“状态重置”。
 *
 * “状态重置”是“回溯”的重要操作，“回溯搜索”是有方向的搜索，否则我们要写多重循环，代码量不可控。
 *
 *
 *
 *当程序第 1 次走到一个结点的时候，表示考虑一个数，要把它加入列表，经过更深层的递归又回到这个结点的时候，需要“状态重置”、“恢复现场”，需要把之前考虑的那个数从末尾弹出，这都是在一个列表的末尾操作，最合适的数据结构是栈（Stack）。
 *
 * 请大家在脑子里想一想程序在这棵递归树上“深度优先遍历”执行的路径，理解了“状态重置”这个概念，是不是觉得“回溯搜索”这个名字很形象。
 *
 *
 *
 *
 *
 */
public class ArrangeSolution {


    public static void main(String[] args) {
        ArrangeSolution solution = new ArrangeSolution();
        List<List<Integer>> results = solution.permute(new int[]{1, 2, 3});
        for (List<Integer> list : results) {
            for (Integer i : list) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    private void generatePermution(int[] nums, boolean[] visited, int curSize, int len, Stack<Integer> path, List<List<Integer>> res) {
        if (curSize == len) {
            // 此时 path 已经保存了 nums 中的所有数字，已经成为了一个排列
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;
                generatePermution(nums, visited, curSize + 1, len, path, res);
                // 刚开始接触回溯算法的时候常常会忽略状态重置
                // 回溯的时候，一定要记得状态重置
                path.pop();
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        if (len == 0) {
            return res;
        }
        generatePermution(nums, used, 0, len, new Stack<>(), res);
        return res;
    }


//    public List<List<Integer>> permute(int[] nums) {
//
//        List<List<Integer>> res = new ArrayList<>();
//        int[] visited = new int[nums.length];
//        backtrack(res, nums, new ArrayList<>(), visited);
//        return res;
//
//    }
//
//    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
//        if (tmp.size() == nums.length) {
//            res.add(new ArrayList<>(tmp));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (visited[i] == 1) continue;
//            visited[i] = 1;
//            tmp.add(nums[i]);
//            backtrack(res, nums, tmp, visited);
//            visited[i] = 0;
//            tmp.remove(tmp.size() - 1);
//        }
//    }


}
