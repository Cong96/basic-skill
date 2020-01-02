package com.datastructure.linkedlist.again;

import com.datastructure.linkedlist.LinkNode;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 21:09
 * @Description: 删除列表中倒数第k个元素
 * 思路不难，唯一的难点是边界的处理
 * 善用哑节点
 */
public class LinkedListDelBootonKSolution {

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
        LinkedListDelBootonKSolution linkedListDelBootonKSolution = new LinkedListDelBootonKSolution();
        LinkNode head = linkedListDelBootonKSolution.removeBottonK(node1, 1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    LinkNode removeBottonK(LinkNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        LinkNode dummyHead = new LinkNode();
        dummyHead.next = head;
        LinkNode fast = dummyHead.next;
        int i = k;
        while (i > 0 && fast != null) {
            fast = fast.next;
            i--;
        }
        if (i > 0) {
            //不符合条件
            return null;
        }
        LinkNode slow = dummyHead;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
