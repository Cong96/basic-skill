package com.leetcode.greedy;

/**
 * @Author: BryantCong
 * @Date: 2019/12/13 13:55
 * @Description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * <p>
 * 贪心算法（又称贪婪算法）是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的是在某种意义上的局部最优解。
 * <p>
 * 贪心算法不是对所有问题都能得到整体最优解，关键是贪心策略的选择，选择的贪心策略必须具备无后效性，即某个状态以前的过程不会影响以后的状态，只与当前状态有关。
 * <p>
 * 链接：https://leetcode-cn.com/tag/greedy/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 可以使用回溯 ，动态规划，贪心算法解决
 */
enum Index {
    GOOD, BAD, UNKNOWN
}

public class JumpSolution {
    public static void main(String[] args) {

    }
    //EXCELLENT
    public boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;

    }

    //自底向上 就是巧妙的安排求解顺序，从最小的子问题开始，自下而上求解。每次求新的问题时，子问题的解已经计算出来了。
    public boolean canJumpDp(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            //查看当前元素右边的index是否可达，一旦是可达的，那么就判断这个右边的index是否能直达到数组末尾index
            for (int j = i + 1; j <= furthestJump; j++) {
                //如果右边的index是可达数组末尾，那么，此时，就可以将当前index也置为可达
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;


    }
}
