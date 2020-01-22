package com.leetcode.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName SmallestStringWithSwapsSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/22 21:46
 * @Version V1.0
 *
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SmallestStringWithSwapsSolution {
    public static void main(String[] args) {

    }

    private int[] father;
    private int[] treeSize;

   public void initUnionFind(int n){
       father=new int[n];
       treeSize=new int[n];
       for(int i=0;i<n;i++){
           father[i]=i;
           treeSize[i]=1;
       }
   }

   public int find(int p){

       if(p!=father[p]){
           father[p]=find(father[p]);
       }
       return father[p];
   }

   public void union(int p,int q){
       int fp=find(p);
       int fq=find(q);
       if(fp!=fq){
           if(treeSize[fp]<treeSize[fq]){
               treeSize[fq]+=treeSize[fp];
               father[fp]=fq;
           }
           else {
               treeSize[fp] += treeSize[fq];
               father[fq]=fp;
           }
       }
   }
    public String smalleststringwithswaps(String s, List<List<Integer>> pairs) {
        int length =s.length();
        initUnionFind(length);
        //先找到有几个集合
        for(List<Integer> pair:pairs){
            union(pair.get(0),pair.get(1));
        }
        //每个集合有一个根
        HashMap<Integer,List<Integer>> rootMap=new HashMap<>();
        //从小到大遍历，使得List<Integer>中的值是有序的(事后不用再排序了)
        for(int i=0;i<length;i++){
           int curRoot= find(i);
            List<Integer> list = rootMap.computeIfAbsent(curRoot, unused -> new ArrayList<>());
            list.add(i);


        }

        StringBuilder res=new StringBuilder(s);
        for(List<Integer> list:rootMap.values()){
            if(list.size()>1){
                int swapListLength=list.size();
                char[] array=new char[swapListLength];
                //有点绕，将当前集合中的字符进行字典排序
                for(int index=0;index<swapListLength;index++){
                   array[index]=res.charAt(list.get(index));
                }
                Arrays.sort(array);
                //字典排序完之后
                for(int index=0;index<swapListLength;index++){
                    res.setCharAt(list.get(index),array[index]);
                }
            }
        }
        return res.toString();
    }
}
