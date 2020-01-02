package com.datastructure.linkedlist.again;

import com.datastructure.linkedlist.LinkNode;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 20:30
 * @Description:
 */
public class LinedListMergeSort {
    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(9);
        LinkNode node2 = new LinkNode(1);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(8);
        LinkNode node5 = new LinkNode(6);
        LinkNode node6 = new LinkNode(5);
        LinkNode node7 = new LinkNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        LinedListMergeSort linedListMergeSort = new LinedListMergeSort();
        LinkNode h = linedListMergeSort.mergeSort(node1);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

    public LinkNode mergeSort(LinkNode head) {
        //当只有一个元素或者没有元素的时候，返回第一个元素或者null
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode slow = head;
        LinkNode fast = head.next;
        while (slow != null && fast!=null&&fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkNode rightStart = slow.next;
        slow.next = null;
        LinkNode left = mergeSort(head);
        LinkNode right = mergeSort(rightStart);
        LinkNode h = new LinkNode();
        LinkNode dummyHead = h;
        while (left != null && right != null) {
            if (left.val > right.val) {
                h.next = right;
                right = right.next;
            } else {
                h.next = left;
                left = left.next;
            }
            h = h.next;
        }
        h.next = left == null ? right : left;

        return dummyHead.next;
    }
}
