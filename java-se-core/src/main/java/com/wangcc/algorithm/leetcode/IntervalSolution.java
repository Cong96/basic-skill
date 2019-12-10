package com.wangcc.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: BryantCong
 * @Date: 2019/10/29 15:56
 * @Description: 时间复杂度 : O(n^2)O(n
 * 2
 * )。需要两重循环。
 * <p>
 * 空间复杂度 : O(n)O(n)。 dpdp 数组占用的空间。
 */
public class IntervalSolution {

    class Interval {
        int start;
        int end;
    }

    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

    public boolean isOverlapping(Interval i, Interval j) {
        return i.end > j.start;
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new myComparator());
        int dp[] = new int[intervals.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (!isOverlapping(intervals[j], intervals[i])) {
                    max = Math.max(dp[j], max);
                    break;
                }
            }
            dp[i] = Math.max(max + 1, dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        return intervals.length - ans;
    }

    public int eraseOverlapIntervals1(Interval[] intervals) {

        Arrays.sort(intervals, new myComparator());
        int prev = 0;
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            //大于等于时，没有重叠，直接下一个区间
            if (intervals[i].start < intervals[prev].end) {
                if (intervals[prev].end > intervals[i].end) {
                    prev=i;
                }
                count++;
            } else {
                prev = i;
            }


        }


//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i].start > intervals[prev].end) {
//                if (intervals[prev].end > intervals[i].end) {
//                    prev = i;
//                }
//                count++;
//            } else {
//                prev = i;
//            }
//        }

        return count;
    }
}
