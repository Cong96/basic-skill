package com.leetcode.unionfind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: BryantCong
 * @Date: 2020/1/19 15:24
 * @Description: 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 深度优先遍历
 *
 * 广度优先遍历
 *
 * FloodFill
 * 并查集
 */
public class NumIslandsSolution {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

    }

    public int numIslands(char[][] grid) {
        return -1;
    }



    void dfs(char[][] grid,int r,int c){
        int rlength=grid.length;
        int clength=grid[0].length;
        if(r<0||r>=rlength||c<0||c>=clength||grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
    /**
    *
    *  深度优先遍历
     * 从一个区域中提取若干个连通的点与其他相邻区域区分开
     * 从一个点扩散开，找到与其连通的点，这不是什么高深的算法，其实就是从一个点开始，进行一次 “深度优先遍历” 或者 “广度优先遍历”，通过 “深度优先遍历” 或者 “广度优先遍历” 发现一片连着的区域，对于这道题来说，就是从一个是 “陆地” 的格子开始进行一次 “深度优先遍历” 或者 “广度优先遍历”，把与之相连的所有的格子都标记上，视为发现了一个 “岛屿”。
     *
     * 说明：这里做 “标记” 的意思是，通过 “深度优先遍历” 或者 “广度优先遍历” 操作，我发现了一个新的格子，与起始点的那个格子是连通的，我们视为 “标记” 过，也可以说 “被访问过”。
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
    * */
    public int numIslandsDfs(char[][] grid){
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++numIslands;
                    dfs(grid, r, c);
                }
            }
        }

        return numIslands;

    }

    /**
     * BFS
     * 广度优先遍历
     *
     */

    public int numIslandsbfs(char[][] grid){
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rlength=grid.length;
        int clength=grid[0].length;
        int numIslands=0;
        for(int r=0;r<rlength;r++){
            for(int c=0;c<clength;c++){
                if(grid[c][r]=='1') {
                    Queue<Integer> queue = new LinkedList<>();
                    grid[c][r]='0';
                    numIslands++;
                    queue.add(r*clength+c);
                    while(!queue.isEmpty()){
                        int id=queue.poll();
                        int row=id/clength;
                        int clo=id%clength;
                        if(row-1>=0&&grid[row-1][clo]=='1'){
                            queue.offer((row-1)*clength+clo);
                            grid[row-1][clo]='0';
                        }
                        if(row+1<rlength&&grid[row+1][clo]=='1'){
                            queue.offer((row+1)*clength+clo);
                            grid[row+1][clo]='0';
                        }
                        if(clo-1>=0&&grid[row][clo-1]=='1'){
                            queue.offer(row*clength+clo-1);
                            grid[row][clo-1]='0';
                        }
                        if(clo+1<clength&&grid[row][clo+1]=='1'){
                            queue.offer(row*clength+clo+1);
                            grid[row][clo+1]='0';
                        }
                    }
                }
            }
        }
        return numIslands;
    }
}

