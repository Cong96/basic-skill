package com.datastructure.linkedlist;

/**
 * @Author: BryantCong
 * @Date: 2019/12/12 10:51
 * @Description: 两个链表相交，找到相交的起点
 * <p>
 * 可以理解成两个人速度一致， 走过的路程一致。那么肯定会同一个时间点到达终点。如果到达终点的最后一段路两人都走的话，那么这段路上俩人肯定是肩并肩手牵手的。
 */
public class LinkedListIntersectionSolution {

    public LinkNode getIntersectionNode(LinkNode headA, LinkNode headB) {
        if (headA == null || headB == null) return null;
        LinkNode la = headA;
        LinkNode lb = headB;
        while (la != lb) {
            la = la == null ? headB : la.next;
            lb = lb == null ? headA : lb.next;
        }
        return la;
    }

}
