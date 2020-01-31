package com.leetcode.listnode;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName RemoveNthFromEndSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 22:07
 * @Version V1.0
 **/
public class RemoveNthFromEndSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }

}
