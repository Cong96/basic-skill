package com.leetcode.trackback.again;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BryantCong
 * @Date: 2020/1/1 22:05
 * @Description:
 */
public class IpSolution {

    public List<String> ipSolution(String ip) {
        List<String> res = new ArrayList<String>();
        if (ip == null || ip.length() < 4) {
            return res;
        }
        return res;
    }

    public void ipSolution(String ip, int pos, Stack<String> track, List<String> result) {
        if (track.size() == 4) {
            if (pos == ip.length()) {
                result.add(String.join(".", new ArrayList<>(track)));
                return;
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (pos + i > ip.length()) {
                break;
            }
            String ipPart = ip.substring(pos, pos + i);
            if (ipPart.startsWith("0") || (ipPart.length() == 3 && Integer.valueOf(ipPart) > 255)) {
                continue;
            }
            track.push(ipPart);
            ipSolution(ip, pos + i, track, result);
            track.pop();
        }
    }
}
