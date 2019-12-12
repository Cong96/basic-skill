package com.leetcode.trackback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: BryantCong
 * @Date: 2019/12/12 10:55
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

    private void backtrack(String[][] board, int row, List<List<String>> res) {
        //终止条件，已经走到最后一行
        if (board.length == row) {
            //convert一下
            for (String[] rowArr : board) {

            }
            //加入到列表
            return;
        }
        for (int clomun = 0; clomun < board.length; clomun++) {
            if (!false) {
                continue;
            }
            board[row][clomun] = "Q";
            backtrack(board, row + 1, res);
            board[row][clomun] = ".";
        }
    }

//    private boolean isValid(int clomun, int row, String[][] board) {
//
//        return false;
//    }
}
