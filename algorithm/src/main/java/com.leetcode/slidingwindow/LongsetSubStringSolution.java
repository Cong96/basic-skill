package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2019/12/12 10:58
 * @Description: 最长不重复子串
 *
 * 使用滑动窗口
 */
public class LongsetSubStringSolution {

    public String longestSubString(String str)
    {
        if(str==null){
            return null;
        }
        if(str.length()<=1){
            return str;
        }
        int left=0;
        int right=0;
        String longestSubString= str.substring(0,1);
        int longestLength=1;
        //窗口
        Map<Character,Integer> windows=new HashMap<>();
        //
        while(right<str.length()){
            char rigthChar=str.charAt(right);
            windows.put(rigthChar,windows.getOrDefault(rigthChar,0)+1);
            right++;
            //一旦最右边的元素出现大于一次,就需要将符合条件的窗口缩小
            //直到新的滑动窗口没有重复元素为止
            while(windows.get(rigthChar)>1){
                char leftChar=str.charAt(left);
                windows.put(leftChar,windows.get(leftChar)-1);
                left++;
            }
            if(right-left+1>longestLength){
                longestLength=right-left+1;
                longestSubString=str.substring(left,right+1);
            }
        }
        return longestSubString;
    }
}
