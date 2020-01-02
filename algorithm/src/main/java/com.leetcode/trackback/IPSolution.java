package com.leetcode.trackback;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2019/12/12 10:56
 * @Description: 还原IP地址
 */
public class IPSolution {


    public List<String> ipSolution(String ip) {
        List<String> res = new ArrayList<String>();
        if (ip == null || ip.length() < 4) {
            return res;
        }
        return res;
    }

    private void ipSolution(String ip, int pos, Stack<String> track, List<String> res) {
        //终止条件 ip的4部分集期了，如果刚好走完string，那就加入结果集，如果不是，那也结束他

        if (track.size() == 4) {
            if (pos == ip.length()) {
                res.add(String.join(".", new ArrayList<>(track)));
                return;
            }
            return;
        }
        //遍历选择列表
        for (int i = 1; i <= 3; i++) {
            if (pos + i > ip.length()) {
                break;
            }
            String ipV4Part = ip.substring(pos, pos + i);
            //排除不符合条件的选择
            if (ipV4Part.startsWith("0") || (ipV4Part.length() == 3 && Integer.valueOf(ipV4Part) > 255)) {
                continue;
            }
            //加入路径
            track.push(ipV4Part);
            //pos+i 入参，即将当前选择从选择列表中移除了
            ipSolution(ip, pos + i, track, res);
            track.pop();
            //由于pos+i只是入参，并没有将pos的值置为pos+i; 所以隐式的帮我们完成了将选择重新加入到选择列表的过程
        }
    }
}
