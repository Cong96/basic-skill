package com.wangcc.algorithm.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/10/31 15:00
 * @Description: 链表两个一组反转
 */
public class TwoListNodeReverseSolution {


    public ListNode reverse(ListNode node) {
        //没有节点或者只有一个节点，直接返回
        if (node == null || node.next == null) {
            return node;
        }
        ListNode next = node.next;
        node = reverse(next.next);
        next.next = node;
        return next;
    }
}
