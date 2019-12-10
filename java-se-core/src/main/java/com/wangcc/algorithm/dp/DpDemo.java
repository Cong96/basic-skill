package com.wangcc.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: BryantCong
 * @Date: 2019/10/24 11:17
 * @Description: 题目：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，再给一个总金额 n，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，则回答 -1 。
 * <p>
 * 比如说，k = 3，面值分别为 1，2，5，总金额 n = 11，那么最少需要 3 枚硬币，即 11 = 5 + 5 + 1 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * f(s)=min_{0<=k<=s} {c(k)+f(s-k)} s.t.
 * c(k)=1
 * base condition: f(0)=0;f(x)=\infty,x<0
 * solution:
 * f(11)=min {c(1)+f(10),c(2)+f(9),c(5)+f(6)}
 * =min {1+f(10),1+f(9),1+f(6)}
 * f(10)=min {1+f(9),1+f(8),1+f(5)}
 * f(9)=min {1+f(8),1+f(7),1+f(4)}
 * f(8)=min {1+f(7),1+f(6),1+f(3)}
 * f(7)=min {1+f(6),1+f(5),1+f(2)}
 * f(6)=min {1+f(5),1+f(4),1+f(1)}
 * f(5)=min {1+f(4),1+f(3),1+f(0)}
 * f(4)=min {1+f(3),1+f(2),1+f(-1)}
 * f(3)=min {1+f(2),1+f(1),1+f(-2)}
 * f(2)=min {1+f(1),1+f(0),1+f(-3)}
 * f(1)=min {1+f(0),1+f(-1),1+f(-4)}
 * f(0)=0
 * 然后采用自底向上进行计算
 */
public class DpDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        System.out.println(coinChange(list, 11));
    }

//    static int coinChange(List<Integer> coins, int sum) {
////        if (sum == 0) return 0;
////        int ans = Integer.MAX_VALUE;
////        for (int coin : coins) {
////            // 金额不可达
////            if (sum - coin < 0) continue;
////            int subProb = coinChange(coins, sum - coin);
////            // 子问题无解
////            if (subProb == -1) continue;
////            ans = Integer.min(ans, subProb + 1);
////        }
////        return ans == Integer.MAX_VALUE ? -1 : ans;
////    }


  static  int coinChange(List<Integer> coins, int amount) {
      int[] dp = new int [amount+1];
      Arrays.fill(dp, amount+1);
      dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 在求所有子问题 + 1 的最小值
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Integer.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
