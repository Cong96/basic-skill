package com.leetcode.twopointer;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName RotateRightListNodeSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 16:49
 * @Version V1.0
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class RotateRightListNodeSolution {
    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;


        int n = 1;
        ListNode tail = head;

        while (tail != null && tail.next != null) {
            n++;
            tail = tail.next;
        }
        tail.next = head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode newHeadBefore = dummyHead;
        //TODO  这是如何算出来的，并不清楚
        for (int j = 0; j <= n - k % n - 1; j++) {
            newHeadBefore = newHeadBefore.next;
        }
        ListNode newHead = newHeadBefore.next;

        newHeadBefore.next = null;
        return newHead;
    }

}
