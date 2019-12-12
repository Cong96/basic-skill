package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MinWindowSolution
 * @Description 返回字符串中 包含指定字符串 的最小子串
 * @Author BryantCong
 * @Date 2019/12/12 21:30
 * @Version V1.0
 **/
public class MinWindowSolution {

    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
    }

    public String minWindow(String str,String target){
        Map<Character,Integer>  windows=new HashMap<>();
        Map<Character,Integer>  needs=new HashMap<>();
        //将需要匹配的内容存入hash表
        for(char c:target.toCharArray()){
            needs.put(c,needs.getOrDefault(c,0)+1);
        }
        int left=0;
        int right=0;
        int match=0;
        int start=0;
        int min=Integer.MIN_VALUE;
        //慢慢缩小滑动窗口
        while(right<str.length()){
            char rightChar=str.charAt(right);
            if(needs.containsKey(rightChar)){
                windows.put(rightChar,windows.getOrDefault(rightChar,0)+1);
                if(windows.get(rightChar)==needs.get(rightChar)){
                    match++;
                }
            }
            //先达到目标条件，然后再缩小滑动窗口
            while(match==needs.size()){
                if(right-left+1<min){
                    min=right-left+1;
                    start=right;
                }
                char leftChar=str.charAt(left);
                if(needs.containsKey(leftChar)){
                    windows.put(leftChar,windows.get(leftChar)-1);
                    if(windows.get(leftChar)<needs.get(leftChar)){
                        match--;
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE?"":str.substring(start,start+min);
    }
}
