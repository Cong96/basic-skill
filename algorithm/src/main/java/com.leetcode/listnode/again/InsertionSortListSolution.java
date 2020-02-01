package com.leetcode.listnode.again;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName InsertionSortListSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 14:32
 * @Version V1.0
 **/
public class InsertionSortListSolution {


    public ListNode insertionSortList(ListNode head) {
        //插入排序
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummyHead;
        ListNode tail = dummyHead;
        //考虑base情况
        ListNode curr = head;
        while (curr != null) {
            if (tail.val < curr.val) {
                ListNode next = curr.next;
                tail.next = curr;
                //切断原链表的联系
                curr.next = null;
                tail = curr;
                curr = next;
            } else {
                while (pre != null && pre.next != null && pre.next.val < curr.val) {
                    pre = pre.next;
                }
                tail.next = curr.next;
                ListNode next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
                pre = dummyHead;
                curr = next;
            }
        }
        return dummyHead.next;
    }

}