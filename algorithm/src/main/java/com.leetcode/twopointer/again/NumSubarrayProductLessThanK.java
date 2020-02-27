package com.leetcode.twopointer.again;

/**
 * @Author: BryantCong
 * @Date: 2020/2/27 10:42
 * @Description: * 给定一个正整数数组 nums。
 * * <p>
 * * 找出该数组内乘积小于 k 的连续的子数组的个数。
 * * <p>
 * * 示例 1:
 * * <p>
 * * 输入: nums = [10,5,2,6], k = 100
 * * 输出: 8
 * * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * * 说明:
 * * <p>
 * * 0 < nums.length <= 50000
 * * 0 < nums[i] < 1000
 * * 0 <= k < 10^6
 * * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //看到连续，就应该想到滑动窗口
        int left = 0;
        int product = 1;
        int length = nums.length;
        int res = 0;
        int right = 0;
        while (right < length) {
            product *= nums[right];
            //while处理是为了排除不符合条件的
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            //这里为什么是对于right每次加这么多呢，其实是这样理解了，因为有多少个元素，就代表着对于当前right会新增多少个组合
            //例如原来是1，2 现在是1,2,3     那么3的出现增加了，1,2,3    2,3    3       也就是可以理解为index从1,到了3，所以也就是多了步长个组合
            res += right - left + 1;
            right++;
        }

        return res;
    }

}