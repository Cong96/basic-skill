package com.datastructure.linkedlist;

/**
 * @Author: BryantCong
 * @Date: 2019/12/12 11:56
 * @Description: 链表两个一组反转   两个一组进行倒置
 */
public class LinkedNodeTwoNodeReverseSolution {

    public LinkNode reverse(LinkNode linkNode) {
        if (linkNode == null || linkNode.next == null) {
            return linkNode;
        }
        LinkNode nextFirstNodeOfTwo = linkNode.next.next;
        LinkNode newFirstNodeOfTwo = linkNode.next;
        linkNode.next.next = linkNode;
        linkNode.next = reverse(nextFirstNodeOfTwo);
        return newFirstNodeOfTwo;
    }
}
