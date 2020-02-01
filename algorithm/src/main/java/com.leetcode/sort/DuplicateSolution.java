package com.leetcode.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DuplicateSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/22 23:08
 * @Version V1.0
 * <p>
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 桶排序的思想来完成
 **/
public class DuplicateSolution {

    public long getId(long i, long w) {
        // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
        //TODO
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Long, Long> bucketMap = new HashMap<>();
        long w = t + 1;
        for (int i = 0; i < nums.length; i++) {
            long m = getId(nums[i], w);
            if (bucketMap.containsKey(m)) {
                return true;
            }
            if (bucketMap.containsKey(m - 1) && Math.abs(nums[i] - bucketMap.get(m - 1)) < w) {
                return true;
            }
            if (bucketMap.containsKey(m + 1) && Math.abs(nums[i] - bucketMap.get(m + 1)) < w) {
                return true;
            }
            // now bucket m is empty and no almost duplicate in nei***or buckets
            bucketMap.put(m, (long) nums[i]);
            if (i >= k) {
                bucketMap.remove(getId(nums[i - k], w));
            }


        }
        return false;
    }
}
