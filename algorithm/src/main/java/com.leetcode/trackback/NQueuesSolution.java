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
    //可以确定的是每一行肯定只能有一个皇后，所以可以一行一行的找
    //行的顺序是确定的，一行一行的往下找合适的放置元素的位置

    private void backtrack(String[][] board, int row, List<List<String>> res) {
        //终止条件，已经走到最后一行
        if (board.length == row) {
            //convert一下
            List<String> rowsStr=new ArrayList<>();
            for (String[] rowArr : board) {
                rowsStr.add(String.join("",rowArr));
            }
            res.add(rowsStr);
            //加入结果集
            return;
        }
        //该行的任何一个位置都是可选的

        for (int column = 0; column < board.length; column++) {
        //排除掉不符合要求的选择
            if (!isValid(column,row,board)) {
                continue;
            }
            //将选择放入路径中
            //同时也恰好把选择从选择列表中去除
            board[row][column] = "Q";
            //回溯
            backtrack(board, row + 1, res);
            //将选择从路径中移除
            //同时也恰好把选择重新放入到选择列表中
            board[row][column] = ".";
        }
    }

//    private boolean isValid(int clomun, int row, String[][] board) {
//
//        return false;
//    }

    private boolean isValid(int column,int row,String [][] board){
        //看同一列是否有冲突
        for(int i=0;i<row;i++){
            if(board[row][column]=="@"){
                return false;
            }
        }
        //查看左上方是否有冲突
        for(int i=row-1,j=column-1;i>0&&j>0;i--,j--){
            if(board[i][j]=="Q"){
                return false;
            }
        }
        //查看右上方是否有冲突
        for(int i=row-1,j=column+1;i>0&&j<board.length;i--,j++){
            if(board[i][j]=="Q"){
                return false;
            }
        }
        return true;
    }
}
