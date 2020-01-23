package com.leetcode.sort;

import com.datastructure.linkedlist.ListNode;

import java.util.List;

/**
 * @ClassName MergeSortListSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/23 16:25
 * @Version V1.0
 **/
public class MergeSortListSolution {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {

        return null;
    }
    public ListNode mergeList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null||fast.next!=null&&slow!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode lStart=head;
        ListNode rStart=slow.next;
        //cut
        slow.next=null;
        ListNode left=mergeList(lStart);
        ListNode right=mergeList(rStart);
        ListNode dummyHead=new ListNode(-1);
        ListNode h=dummyHead;
        while(left!=null&&right!=null){
            if(left.val>right.val){
                h.next=left;
                left=left.next;
            }
            else{
                h.next=right;
                right=right.next;
            }
            h=h.next;
        }
        h.next=right!=null?right:left;
        return dummyHead.next;
    }
}
