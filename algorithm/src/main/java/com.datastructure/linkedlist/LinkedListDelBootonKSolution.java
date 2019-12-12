package com.datastructure.linkedlist;

/**
 * @Author: BryantCong
 * @Date: 2019/12/12 10:52
 * @Description: 删除倒数第k个节点
 * <p>
 * 其实难点只在如何兼容边界情况
 */
public class LinkedListDelBootonKSolution {

    public LinkNode delBootonK(LinkNode linkNode, int k) {
        LinkNode head = linkNode;
        LinkNode slow = linkNode;
        LinkNode fast = linkNode.next;
        //依然使用快慢双指针，但是，我们其实要获取的是要删除节点的前一个节点
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            if (k == 1) {
                return head.next;
            } else {
                //链表长度超出
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
