package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName NumDecodingsSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 16:52
 * @Version V1.0
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NumDecodingsSolution {

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(s.substring(0, 1));
    }


    public int numDecodings(String s) {
        List<String> res = new ArrayList<>();
        trackback(s, res, new Stack<>(), 0);
        return res.size();
    }

    public void trackback(String s, List<String> res, Stack<String> track, int index) {
        int length = s.length();
        if (index == length) {
            //TODO
            res.add(String.join(".", new ArrayList<>(track)));
            return;
        }
        //遍历可能的所有情景
        for (int i = 1; i <= 2; i++) {
            if (index + i > length) {
                break;
            }
            String part = s.substring(index, index + i);
            //过滤掉不符合条件的场景
            if (part.startsWith("0")) {
                continue;
            }
            //放入到路径中
            track.push(part);
            trackback(s, res, track, index + i);
            //从路径中去掉
            track.pop();
        }

    }
}
