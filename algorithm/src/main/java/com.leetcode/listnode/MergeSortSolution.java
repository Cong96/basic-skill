package com.leetcode.listnode;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName MergeSortSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 0:43
 * @Version V1.0
 **/
public class MergeSortSolution {
    public static void main(String[] args) {

    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode right = mergeSort(head);
        ListNode left = mergeSort(temp);
        ListNode dummyHead = new ListNode(-1);
        ListNode h = dummyHead;
        while (right != null && left != null) {
            if (right.val > left.val) {
                h.next = left;
                left = left.next;
                h = h.next;
            } else {
                h.next = right;
                right = right.next;
                h = h.next;
            }
        }
        h.next = left == null ? right : left;

        return dummyHead.next;
    }
}