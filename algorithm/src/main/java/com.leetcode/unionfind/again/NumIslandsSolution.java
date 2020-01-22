package com.leetcode.unionfind.again;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NumIslandsSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/22 11:04
 * @Version V1.0
 **/
public class NumIslandsSolution {
    public static void main(String[] args) {

    }



    public int numIslandsDfs(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int rowLength=grid.length;
        int cloLength=grid[0].length;
        int numIslands=0;
        for(int row=0;row<rowLength;row++){
            for(int clo=0;clo<cloLength;clo++){
                if(grid[row][clo]=='1'){
                    numIslands++;

                }
            }
        }
        return numIslands;
    }
    public void dfs(char[][] grid,int row,int clo){
        int cloLength=grid[0].length;
        int rowLength=grid.length;
        if(row<0||row>=rowLength||clo<0||clo>=cloLength||grid[row][clo]=='0'){
            return;
        }
        //标记当前位置已经访问过
        grid[row][clo]='0';
        dfs(grid,row,clo+1);
        dfs(grid,row,clo-1);
        dfs(grid,row-1,clo);
        dfs(grid,row+1,clo);
    }

    public int numIslandsBfs(char[][] grid){
        if(grid==null||grid.length==0){
            return 0;
        }
        int cloLength=grid[0].length;
        int rowLength=grid.length;
        int numIslands=0;
        for(int row=0;row<rowLength;row++){
            for(int clo=0;clo<cloLength;clo++){
                if(grid[row][clo]=='1'){
                    numIslands++;
                    grid[row][clo]='0';
                    Queue<Integer> queue=new LinkedList<>();
                    queue.offer(row*cloLength+clo);
                    while (!queue.isEmpty()){
                        int id=queue.poll();
                        int curRow=id/cloLength;
                        int curClo=id%cloLength;
                        if(curClo-1>0&&grid[curRow][curClo-1]=='1'){
                            queue.offer(curRow*cloLength+curRow-1);
                            grid[curRow][curClo-1]='0';
                        }
                        //上下左右都是这样，是否可以抽出来
                    }
                }
            }
        }
        return numIslands;
    }

    /**
     *
     *
     *
     */
    //找出每个节点的父节点
    private int[] father;
    //每个节点的权
    private int[] rank;

    private int count;
    public int numIslandsUnionFind(char[][] grid){
        if(grid==null||grid.length==0){
            return 0;
        }
        initUnionFind(grid);
        int cloLength=grid[0].length;
        int rowLength=grid.length;
        for(int row=0;row<rowLength;row++){
            for(int clo=0;clo<cloLength;clo++){
                if(grid[row][clo]=='1'){
                    //对上下左右进行union

                }
            }
        }
        return -1;
    }

    public void union(int p,int q){
        int fq=find(q);
        int fp=find(p);
        //相等，代表已联通
        if(fq!=fp){
            if(rank[fp]<rank[fq]){
                rank[fq]+=1;
                father[p]=fq;
            }
            else{
                rank[fp]+=1;
                father[q]=fp;
            }
            //他们是连在一起的，去掉
            count--;
        }
    }

    public int find(int p){
        if(father[p]!=p){
            father[p]=find(father[p]);
        }
        return father[p];
    }

    public void initUnionFind(char[][] grid){
        int cloLength=grid[0].length;
        int rowLength=grid.length;
        father=new int[cloLength*rowLength];
        rank=new int[cloLength*rowLength];
        for(int row=0;row<rowLength;row++){
            for(int clo=0;clo<cloLength;clo++){
                if(grid[row][clo]=='1'){
                    count++;
                    father[row*cloLength+clo]=row*cloLength+clo;
                }
            }
        }
    }
}