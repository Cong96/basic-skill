package com.leetcode.greedy;

/**
 * @ClassName CompleteCircuitSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 15:23
 * @Version V1.0
 * * @Description: 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * * <p>
 * * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * * <p>
 * * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * * <p>
 * * 说明: 
 * * <p>
 * * 如果题目有解，该答案即为唯一答案。
 * * 输入数组均为非空数组，且长度相同。
 * * 输入数组中的元素均为非负数。
 * * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/gas-station
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CompleteCircuitSolution {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int spare = 0;
        int length = gas.length;
        int targetIndex = -1;
        int minSpare = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                targetIndex = i;
            }
        }
        if (spare < 0) {
            return -1;
        }
        return (targetIndex + 1) % length;
    }
}
