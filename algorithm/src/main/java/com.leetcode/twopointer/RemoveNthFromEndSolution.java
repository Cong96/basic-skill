package com.leetcode.twopointer;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName RemoveNthFromEndSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 17:11
 * @Version V1.0
 **/
public class RemoveNthFromEndSolution {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //善用哑节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode sencond = dummyHead;
        //边界条件，只需要代入特殊条件和常规条件两个测试即可
        //注意，在有些场景下，特殊条件有自己的case分支
        //代入条件即可
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            sencond = sencond.next;
        }
        sencond.next = sencond.next.next;
        return dummyHead.next;
    }

}
