package com.leetcode.sort;

import java.util.*;

/**
 * @ClassName MergeArraysSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/22 21:51
 * @Version V1.0
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MergeArraysSolution {
    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList=new ArrayList<>();
        for(int[] interval:intervals){
            intervalList.add(new Interval(interval));
        }
        List<Interval> intervalResList=   merge(intervalList);
        int[][] res=new int[intervalResList.size()][2];
        int i=0;
        for(Interval interval:intervalResList){
            res[i]=interval.toArray();
            i++;
        }
        return res;
    }

   class Interval{
        public int start;
        public int end;
       Interval(int[] interval) {
           this.start = interval[0];
           this.end = interval[1];
       }

       int[] toArray() {
           return new int[]{this.start, this.end};
       }
    }
    class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start>o2.start?1:o1.start==o2.start?0:-1;
        }
    }




    public List<Interval> merge(List<Interval> intervals){
        LinkedList<Interval> merged=new LinkedList<>();
        merged.sort(new IntervalComparator());
        for(Interval interval:intervals){
            if(merged.isEmpty()||merged.getLast().end<interval.start){
                merged.add(interval);
            }
            else{
                merged.getLast().end=Math.max(merged.getLast().end,interval.end);
            }
        }
        return merged;
    }
}
