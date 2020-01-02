package com.datastructure.linkedlist;

/**
 * @Author: BryantCong
 * @Date: 2019/12/11 10:11
 * @Description: 链表的归并排序
 * ERROR
 */
public class LinkedListMergeSort {


    public LinkNode mergeSort(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //双指针  确定mid
        LinkNode fast = head.next;
        LinkNode slow = head;
        //怎么确定 slow是不是也使用head.next 其实对于这些的设定，使用边界值套入一下就好了，比如使用只有两个节点的情况来套一下，看是否满足
        while (slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        LinkNode temp = slow.next;
        /*
         * 分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
         *递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
         *
         *
         *
         * */
        //
        slow.next = null;
        LinkNode left = mergeSort(head);
        LinkNode right = mergeSort(temp);
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
        return dummyHead.next;

        //找到
    }
}
