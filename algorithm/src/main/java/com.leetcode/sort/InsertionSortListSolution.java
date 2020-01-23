package com.leetcode.sort;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName InsertionSortListSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/23 15:12
 * @Version V1.0
 **/
public class InsertionSortListSolution {
    public static void main(String[] args) {

    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead=new ListNode(-1);
        ListNode pre=dummyHead;
        ListNode tail=dummyHead;
        ListNode curr=head;
        while(curr!=null){
            if(tail.val<curr.val){
                ListNode next=curr.next;
                tail.next=curr;
                tail=curr;
                curr=next;
            }
            else{
                ListNode next=curr.next;
                tail.next=next;
                while(pre!=null&&pre.next!=null&&pre.next.val<curr.val){
                    pre=pre.next;
                }
                curr.next=pre.next;
                pre.next=curr;
                pre=dummyHead;
                curr=next;
            }
        }
        return dummyHead.next;
    }
}
