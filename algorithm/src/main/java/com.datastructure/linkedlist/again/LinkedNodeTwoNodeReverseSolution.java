package com.datastructure.linkedlist.again;

import com.datastructure.linkedlist.LinkNode;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 21:34
 * @Description: 两两一组反转
 */
public class LinkedNodeTwoNodeReverseSolution {
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

        LinkedNodeTwoNodeReverseSolution linkedNodeTwoNodeReverseSolution=new LinkedNodeTwoNodeReverseSolution();
        LinkNode node =linkedNodeTwoNodeReverseSolution.reverse(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public LinkNode reverse(LinkNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        LinkNode newHead = head.next;
        LinkNode next = newHead.next;
        head.next.next = head;
        head.next = reverse(next);
        return newHead;
    }

}
