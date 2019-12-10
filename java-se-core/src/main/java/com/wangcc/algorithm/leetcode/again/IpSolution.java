package com.wangcc.algorithm.leetcode.again;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2019/10/31 16:01
 * @Description:
 */
public class IpSolution {

    public static void main(String[] args) {
        String ip="25525511135";
        IpSolution ipSolution=new IpSolution();
        List<String> list=ipSolution.ip(ip);
        for(String str:list){
            System.out.println(str);
        }
    }
    public List<String> ip(String s) {
        List<String> res=new ArrayList<>();
        if(s==null||s.length()<4){
            return res;
        }
        backtracking(0,s,new Stack<>(),res);
        return res;
    }

    public void backtracking(int pos, String ip, Stack<String> stack, List<String> res) {
        if (stack.size() == 4) {
            if (pos == ip.length()) {
                res.add(String.join(".", new ArrayList<>(stack)));
                return;
            } else {
                return;
            }
        }
        for (int i = 1; i <= 3; i++) {
            if (pos + i > ip.length()) {
                break;
            }
            String ipV4Part = ip.substring(pos, pos + i);
            if ((ipV4Part.length() > 1 && ipV4Part.startsWith("0")) || (ipV4Part.length() == 3 && Integer.valueOf(ipV4Part) > 255)) {
                continue;
            }
            stack.push(ipV4Part);
            backtracking(pos + i, ip, stack, res);
            stack.pop();
        }

    }

}
