package com.leetcode.listnode;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName ReverseKGroupSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 22:27
 * @Version V1.0
 **/
public class ReverseKGroupSolution {
    public static void main(String[] args) {

    }


    //k个一组反转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0) {
            return head;
        }
        ListNode a, b;
        a = b = head;
        //我们要确定下，如果链表总共3个节点，那么我们遍历三次，那么最后b就是null
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    ListNode reverse(ListNode start, ListNode end) {
        //end是开区间
        //反转链表
        ListNode dummyhead = new ListNode(-1);
        ListNode curr = start;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = dummyhead.next;
            dummyhead.next = curr;
            curr = next;
        }
        return dummyhead.next;
    }
}