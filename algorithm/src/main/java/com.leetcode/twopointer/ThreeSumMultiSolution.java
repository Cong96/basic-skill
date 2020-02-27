package com.leetcode.twopointer;

/**
 * @ClassName ThreeSumMultiSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 17:09
 * @Version V1.0
 * <p>
 * 给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
 * <p>
 * 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8
 * 输出：20
 * 解释：
 * 按值枚举（A[i]，A[j]，A[k]）：
 * (1, 2, 5) 出现 8 次；
 * (1, 3, 4) 出现 8 次；
 * (2, 2, 4) 出现 2 次；
 * (2, 3, 3) 出现 2 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-with-multiplicity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ThreeSumMultiSolution {
    public int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;

        return -1;
    }
}
