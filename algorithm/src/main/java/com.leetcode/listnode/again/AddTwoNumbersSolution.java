package com.leetcode.listnode.again;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName AddTwoNumbersSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 21:59
 * @Version V1.0
 **/
public class AddTwoNumbersSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        //进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = carry + l1Val + l2Val;
            //是否有进位
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //看最后是否还有进位
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
