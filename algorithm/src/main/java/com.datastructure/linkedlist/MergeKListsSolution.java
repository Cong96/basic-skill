package com.datastructure.linkedlist;

/**
 * @Author: BryantCong
 * @Date: 2020/1/6 16:42
 * @Description: 其实不过就是链表归并排序的小升级
 */
public class MergeKListsSolution {
    public LinkNode mergeKLists(LinkNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        // 将n个链表以中间为对称，合并，即合并
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[len - 1 - i]);
            }
            len = (len + 1) / 2;
        }
        return lists[0];
    }

    // 合并两个链表
    public LinkNode mergeTwoLists(LinkNode l1, LinkNode l2) {
        LinkNode head = new LinkNode(-1);
        LinkNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }

}
