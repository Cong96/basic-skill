package com.wangcc.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: BryantCong
 * @Date: 2019/10/28 17:31
 * @Description:
 *
 *
 * 题目理解：
 * 字符串 s 是以 ZZ 字形为顺序存储的字符串，目标是按行打印。
 * 设 numRows 行字符串分别为 s_1s
 * 1
 * ​
 *   , s_2s
 * 2
 * ​
 *   ,..., s_ns
 * n
 * ​
 *  ，则容易发现：按顺序遍历字符串 s 时，每个字符 c 在 ZZ 字形中对应的 行索引 先从 s_1s
 * 1
 * ​
 *   增大至 s_ns
 * n
 * ​
 *  ，再从 s_ns
 * n
 * ​
 *   减小至 s_1s
 * 1
 * ​
 *   …… 如此反复。
 * 因此，解决方案为：模拟这个行索引的变化，在遍历 s 中把每个字符填到正确的行 res[i] 。
 * 算法流程： 按顺序遍历字符串 s；
 * res[i] += c： 把每个字符 c 填入对应行 s_is
 * i
 * ​
 *  ；
 * i += flag： 更新当前字符 c 对应的行索引；
 * flag = - flag： 在达到 ZZ 字形转折点时，执行反向。
 * 复杂度分析：
 * 时间复杂度 O(N)O(N) ：遍历一遍字符串 s；
 * 空间复杂度 O(N)O(N) ：各行字符串共占用 O(N)O(N) 额外空间。
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ZConvertSolution {


    public static void main(String[] args) {
        String s="LEETCODEISHIRING";
        System.out.println(convert(s,3));
    }
    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }

}
