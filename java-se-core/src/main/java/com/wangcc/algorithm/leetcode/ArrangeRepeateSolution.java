package com.wangcc.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2019/10/29 13:43
 * @Description:
 */
public class ArrangeRepeateSolution {


    public static void main(String[] args) {
        ArrangeRepeateSolution solution = new ArrangeRepeateSolution();
        List<List<Integer>> results = solution.permute(new int[]{1, 2, 2, 3, 3, 4, 4});
        for (List<Integer> list : results) {
            for (Integer i : list) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();

        if (arr == null || arr.length == 0) {
            return res;
        }
        boolean[] used = new boolean[arr.length];


        findPermuteUnique(arr, used, 0, arr.length, new Stack<>(), res);
        return res;
        //      List<List<Integer>>
    }

    public void findPermuteUnique(int[] arr, boolean[] used, int curSize, int length, Stack<Integer> path, List<List<Integer>> res) {
        if (curSize == length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                //这里的条件 !used[i-1]其实也可以改为used[i-1]

                /*
                 * 如果是使用的!used[i-1]，那么也就意味着，相同的元素，只允许一种排列方式，那就是数组下标最大的在前面，根据数组下标递减排列
                 * 如果使用used[i-1]，那么就是根据数组下标递增排列
                 *
                 * */
                if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                    continue;
                }
                path.push(arr[i]);
                used[i] = true;
                //为什么一定是在方法参数里面curSize+1， 必须要这样，否则，你把最外层循环的当前size破坏了
                findPermuteUnique(arr, used, curSize + 1, length, path, res);
                path.pop();
                used[i] = false;
            }
        }
    }

//
//    public void findPermuteUnique(int[] arr, boolean[] used, int curSize, int len, Stack<Integer> stack, List<List<Integer>> res) {
//        if (curSize == len) {
//            res.add(new ArrayList<>(stack));
//            return;
//        }
//        for (int i = 0; i < len; i++) {
//
//            if (!used[i]) {
////                if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
////                    continue;
////                }
//                stack.push(arr[i]);
//                used[i] = true;
//                curSize++;
//                findPermuteUnique(arr,used,curSize,len,stack,res);
//                stack.pop();
//                used[i]=false;
//            }
//        }
//
//
//    }

}
