package com.leetcode.trackback;

import java.util.List;
import java.util.Map;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 13:42
 * @Description: 今天我们看到的阿里巴巴提供的任何一项服务后边都有着无数子系统和组件的支撑，子系统之间也互相依赖关联，
 * <p>
 * 其中任意一个环节出现问题都可能对上游链路产生影响。小明做为新人接收到的第一个任务就是去梳理所有的依赖关系，
 * <p>
 * 小明和每个系统的负责人确认了依赖关系，记录下调用对应系统的耗时，用这些数据分析端到端链路的数目和链路上最长的耗时。
 * <p>
 * 输入： 小明搜集到的系统耗时和依赖列表
 * <p>
 * 5 4 // 表示有5个系统和 4个依赖关系
 * <p>
 * 3 // 调用1号系统耗时 3 ms
 * <p>
 * 2 // 调用2号系统耗时 2 ms
 * <p>
 * 10 // 调用3号系统耗时 10 ms
 * <p>
 * 5 // 调用4号系统耗时 5 ms
 * <p>
 * 7 // 调用5号系统耗时 7 ms
 * <p>
 * 1 2 // 2号系统依赖1号系统
 * <p>
 * 1 3 // 3号系统依赖1号系统
 * <p>
 * 2 5 // 5号系统依赖2号系统
 * <p>
 * 4 5 // 5号系统依赖4号系统
 * <p>
 * <p>
 * 输出: 调用链路的数目 和最大的耗时， 这里有三条链路1->2->5，1->3， 4->5，最大的耗时是1到3的链路 3+10 = 13，无需考虑环形依赖的存在。
 */
class Result {
 private int amount;
 private int cost;

}

public class AliSolution {


    public static void main(String[] args) {

    }

    public void aliSolution(List<List<Integer>> dependencies, Map<Integer, Integer> costMap) {

    }

}
