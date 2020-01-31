package com.leetcode.twopointer;

import java.util.Arrays;

/**
 * @ClassName MaxProfitAssignmentSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 12:50
 * @Version V1.0
 * <p>
 * 有一些工作：difficulty[i] 表示第i个工作的难度，profit[i]表示第i个工作的收益。
 * <p>
 * 现在我们有一些工人。worker[i]是第i个工人的能力，即该工人只能完成难度小于等于worker[i]的工作。
 * <p>
 * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 * <p>
 * 举个例子，如果3个工人都尝试完成一份报酬为1的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 * <p>
 * 我们能得到的最大收益是多少？
 * <p>
 * 示例：
 * <p>
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-profit-assigning-work
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxProfitAssignmentSolution {

    public static void main(String[] args) {

    }

    class Job {
        public int difficulty;
        public int profit;

        public Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }


    //如果我们先访问低难度的工作，那么收益一定是截至目前最好的。
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (difficulty == null || difficulty.length == 0 || profit == null || profit.length == 0 || worker == null || worker.length == 0) {
            return 0;
        }
        //TODO
        int N = difficulty.length;
        Job[] jobs = new Job[N];
        for (int i = 0; i < N; ++i)
            jobs[i] = new Job(difficulty[i], profit[i]);
        //按照工作难度升序
        Arrays.sort(jobs, (a, b) -> a.difficulty - b.difficulty);
        //按照工人能力升序排序
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
        //找到当前能力最差的工人能带来的最大收益
        for (int skill : worker) {
            while (i < N && skill >= jobs[i].difficulty)
                best = Math.max(best, jobs[i++].profit);
            ans += best;
        }

        return ans;

    }

}
