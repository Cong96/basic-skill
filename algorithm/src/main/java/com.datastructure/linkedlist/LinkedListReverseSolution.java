package com.datastructure.linkedlist;

/**
 * @Author: BryantCong
 * @Date: 2019/12/12 10:52
 * @Description: 链表倒置
 * <p>
 * 在大多有关链表的操作中，我们要善用哑头节点
 */
public class LinkedListReverseSolution {

    public LinkNode reverse(LinkNode linkNode) {
        LinkNode dummyHead = new LinkNode();
        LinkNode h = linkNode;
        while (h != null) {
            LinkNode next = h.next;
            h.next = dummyHead.next;
            dummyHead.next = h;
            h = next;
        }
        return dummyHead.next;
    }
}
