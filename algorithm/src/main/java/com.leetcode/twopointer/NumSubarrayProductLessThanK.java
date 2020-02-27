package com.leetcode.twopointer;

/**
 * @ClassName NumSubarrayProductLessThanK
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 13:58
 * @Version V1.0
 * <p>
 * 给定一个正整数数组 nums。
 * <p>
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 说明:
 * <p>
 * 0 < nums.length <= 50000
 * 0 < nums[i] < 1000
 * 0 <= k < 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NumSubarrayProductLessThanK {
    //依旧是可以使用滑动窗口
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int length = nums.length;
        int currMutil = 1;
        int res = 0;
        for (int right = 0; right < length; right++) {
            currMutil = currMutil * nums[right];
            //2 3 10
            while (currMutil >= k && left <= right) {
                currMutil = currMutil / nums[left];
                left++;
            }
            //TODO 主要是这个数学我没整明白
            res+= right - left + 1;
        }
        return res;
    }
}
