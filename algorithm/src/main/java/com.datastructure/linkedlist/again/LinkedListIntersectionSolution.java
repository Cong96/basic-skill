package com.datastructure.linkedlist.again;

import com.datastructure.linkedlist.LinkNode;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 21:31
 * @Description: TODO K个链表相交
 * <p>
 * 两个链表相交，找到相交的起点
 */
public class LinkedListIntersectionSolution {

    public static void main(String[] args) {


    }

    public LinkNode findIntersection(LinkNode h1, LinkNode h2) {
        while (h1 != h2) {
            h1 = h1 == null ? h2 : h1.next;
            h2 = h2 == null ? h1 : h2.next;
        }
        return h1;
    }
}
