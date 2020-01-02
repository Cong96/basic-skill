package com.datastructure.linkedlist.again;

import com.datastructure.linkedlist.LinkNode;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 21:34
 * @Description: 链表反转
 */
public class LinkedListReverseSolution {

    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        LinkNode node6 = new LinkNode(6);
        LinkNode node7 = new LinkNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        LinkedListReverseSolution linkedNodeTwoNodeReverseSolution = new LinkedListReverseSolution();
        LinkNode head = linkedNodeTwoNodeReverseSolution.reverse(node1);
        LinkNode node =head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public LinkNode reverse(LinkNode head) {

        LinkNode dummyHead = new LinkNode();
        while (head != null) {
            LinkNode temp = head.next;
            head.next = dummyHead.next;

            dummyHead.next = head;
            head = temp;
        }
        return dummyHead.next;
    }
}
