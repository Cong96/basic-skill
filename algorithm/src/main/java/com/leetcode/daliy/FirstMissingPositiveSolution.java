package com.leetcode.daliy;

/**
 * @description: 找出缺失的第一个正数
 * @author: BryantCong
 * @create: 2020-06-27 14:45
 * <p>
 * <p>
 * <p>
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 * <p>
 * 提示：
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstMissingPositiveSolution {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, -1, 1};
        FirstMissingPositiveSolution firstMissingPositiveSolution = new FirstMissingPositiveSolution();
        firstMissingPositiveSolution.firstMissingPositive(array);
    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        /**
         * 时间复杂度o(n)
         *
         * 何时为n^2呢？
         * 主体操作进行了两层for循环
         * 注意 n层for循环与m个循环的区别  m个（常数级）for循环 就是o(n)
         *
         */
        //先将负数都变成length+1  全变成正数
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) {
                nums[i] = length + 1;
            }
        }
        for (int i = 0; i < length; i++) {
            //注意这个绝对值的操作，非常的巧妙
            int current = Math.abs(nums[i]);

            if (current <= length) {
                //还是可以拿到该位置的原值
                nums[current - 1] = -Math.abs(nums[current - 1]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

//    public int firstMissingPositive1(int[] nums) {
//        int length = nums.length;
//
//        for (int i = 0; i < length; i++) {
//            int num = nums[i];
//            if (num <= length && num >= 1) {
//                nums[num - 1] = num;
//            }
//        }
//        for (int i = 0; i < length; i++) {
//            if (nums[i] != i + 1) {
//                return i + 1;
//            }
//        }
//        return length + 1;
//    }
}
