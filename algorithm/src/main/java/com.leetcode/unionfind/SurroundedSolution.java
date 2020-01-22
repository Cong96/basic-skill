package com.leetcode.unionfind;

/**
 * @ClassName SurroundedSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/22 11:55
 * @Version V1.0
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 需要有逆向思维能力
 *
 **/
public class SurroundedSolution {
    public static void main(String[] args) {

    }

    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};



    public void solve(char[][] board) {
        //对于4个边框进行dfs
        if(board==null||board.length==0){
            return;
        }
        int cloLength=board[0].length;
        int rowLength=board.length;
        for(int row=0;row<rowLength;row++){
            for(int clo=0;clo<cloLength;clo++){
                boolean isEdge=row==0|row==rowLength-1||clo==0||clo==cloLength-1;
                if(isEdge&&board[row][clo]=='O'){
                    board[row][clo]='B';
                    dfs(board,row,clo);
                }
            }
        }
        for(int row=0;row<rowLength;row++){
            for(int clo=0;clo<cloLength;clo++){
                if(board[row][clo]=='O'){
                    board[row][clo]='X';
                }
                if(board[row][clo]=='B'){
                    board[row][clo]='O';
                }
            }
        }

    }

    public void dfs(char[][] board,int row,int clo){
        int cloLength=board[0].length;
        int rowLength=board.length;
        for(int i=0;i<4;i++){
            int newRow=rowLength+directions[i][0];
            int newClo=cloLength+directions[i][1];
            if(newRow>=0&&newRow<rowLength&&newClo>=0&&newClo>=cloLength&&board[newRow][newClo]=='O'){
                board[newRow][newClo]='B';
                dfs(board,newRow,newClo);
            }
        }
    }
}
