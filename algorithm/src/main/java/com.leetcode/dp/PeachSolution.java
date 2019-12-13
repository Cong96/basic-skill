package com.leetcode.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/12/12 10:58
 * @Description: 桃子问题
 * <p>
 * 动态规划（英语：Dynamic programming，简称 DP）是一种在数学、管理科学、计算机科学、经济学和生物信息学中使用的，通过把原问题分解为相对简单的子问题的方式求解复杂问题的方法。
 * <p>
 * 动态规划常常适用于有重叠子问题和最优子结构性质的问题，动态规划方法所耗时间往往远少于朴素解法。
 * <p>
 * 动态规划背后的基本思想非常简单。大致上，若要解一个给定问题，我们需要解其不同部分（即子问题），再根据子问题的解以得出原问题的解。动态规划往往用于优化递归问题，例如斐波那契数列，如果运用递归的方式来求解会重复计算很多相同的子问题，利用动态规划的思想可以减少计算量。
 * <p>
 * 通常许多子问题非常相似，为此动态规划法试图仅仅解决每个子问题一次，具有天然剪枝的功能，从而减少计算量：一旦某个给定子问题的解已经算出，则将其记忆化存储，以便下次需要同一个子问题解之时直接查表。这种做法在重复子问题的数目关于输入的规模呈指数增长时特别有用。
 * <p>
 * 链接：https://leetcode-cn.com/tag/dynamic-programming/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PeachSolution {
    public static void main(String[] args) {
        int[] peaches = new int[]{2, 5, 1, 8, 4, 6, 7};
        PeachSolution peachSolution = new PeachSolution();
        System.out.println(peachSolution.pick(peaches));
    }

    public int pick(int[] peaches) {

        int[] dp = new int[peaches.length];
        dp[0] = 1;
        for (int right = 1; right < peaches.length; right++) {
            //初始化为1，默认前面的元素都不小于他
            dp[right] = 1;
            for (int left = 0; left < right; left++) {
                //找到前面不大于当前选择值的元素left，我们可以知道一旦有这样的left，那么
                //当前元素的dp[right] 至少就是dp[left]+1了，我们就是要早到，当出现left小于等于right时，最大的dp[left]
                //dp{left}+1则是我们需要的结果
                if (peaches[left] <= peaches[right] && dp[left] + 1 > dp[right]) {
                    dp[right] = dp[left] + 1;
                }
            }

        }

        int max = 1;
        for (int i : dp) {
            max = i > max ? i : max;
        }
        return max;
    }
}
