package com.wangcc.algorithm.leetcode.again;

/**
 * @Author: BryantCong
 * @Date: 2019/10/31 13:54
 * @Description:
 */
public class ListNodeMergeSort {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNodeMergeSort sort = new ListNodeMergeSort();
        ListNode head = sort.mergeSort(l1);
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
//
//        ListNode listNode = sort.reverse(head);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }

        ListNode k = sort.find(head, 7);
        System.out.println(k.val);

        ListNode h = sort.removefindK(head, 6);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

    public ListNode removefindK(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead.next;
        ListNode slow = dummyHead;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }

    public ListNode find(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //两两一组倒序
    public ListNode reverse(ListNode node) {
        //没有节点或者只有一个节点，直接返回
        if (node == null || node.next == null) {
            return node;
        }
        ListNode next = node.next;
        node.next = reverse(next.next);
        next.next = node;
        return next;
    }

    public ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;  //断开链表
        ListNode l1 = mergeSort(node);
        ListNode l2 = mergeSort(temp);
        ListNode dummyHead = new ListNode(-1);
        ListNode res = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                dummyHead.next = l2;
                l2 = l2.next;
            } else {
                dummyHead.next = l1;
                l1 = l1.next;
            }
            dummyHead = dummyHead.next;
        }
        dummyHead.next = l1 == null ? l2 : l1;
        return res.next;
    }

    public ListNode quickSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode slow = node;
        ListNode fast = node.next;
        int temp = node.val;
        while (fast != null) {
            if (fast.val < temp) {
            }
        }

        return null;
    }
}
