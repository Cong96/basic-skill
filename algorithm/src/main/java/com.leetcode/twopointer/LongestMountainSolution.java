package com.leetcode.twopointer;

/**
 * @ClassName LongestMountainSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 15:58
 * @Version V1.0
 * <p>
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LongestMountainSolution {
    public int longestMountain(int[] mountains) {
        int length = mountains.length;
        int res = 0;
        int base = 0;
        while (base < length) {
            int end = base;
            //是否可以开启一个山脉的探索，是否符合初始基本条件
            if (end + 1 < length && mountains[end] < mountains[end + 1]) {
                //上坡部分
                while (end + 1 < length && mountains[end] < mountains[end + 1]) {
                    end++;
                }
                //是否符合山脉的第二个特征
                if (end + 1 < length && mountains[end] > mountains[end + 1]) {
                    //下坡部分
                    while (end + 1 < length && mountains[end] > mountains[end + 1]) {
                        end++;
                    }
                    res = Math.max(res, end - base + 1);
                }
            }
            //如果之前是山脉，那么就在山脉的末尾开始新的山脉的寻找
            //否则，就从下个元素开始
            base = Math.max(end, base + 1);
        }
        return res;
    }
}
