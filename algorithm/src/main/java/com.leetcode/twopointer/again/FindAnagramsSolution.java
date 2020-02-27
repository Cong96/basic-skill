package com.leetcode.twopointer.again;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: BryantCong
 * @Date: 2020/2/27 10:43
 * @Description:
 *
 *  * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *  * <p>
 *  * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 */
public class FindAnagramsSolution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if(s==null||s.length()==0||p==null||p.length()==0||s.length()>p.length()){
            return res;
        }

        return null;
    }
}