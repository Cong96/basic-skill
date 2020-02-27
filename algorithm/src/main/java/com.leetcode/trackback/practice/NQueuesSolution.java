package com.leetcode.trackback.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: BryantCong
 * @Date: 2020/2/25 15:51
 * @Description: N皇后问题
 */
public class NQueuesSolution {


    public List<List<String>> nqueues(int n) {
        List<List<String>> res = new ArrayList<>();
        String[][] board = new String[n][n];
        for (String[] arrs : board) {
            Arrays.fill(arrs, ".");
        }

        return res;
    }
}
