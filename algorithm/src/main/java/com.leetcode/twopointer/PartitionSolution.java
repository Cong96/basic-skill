package com.leetcode.twopointer;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName PartitionSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 14:44
 * @Version V1.0
 * <p>
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class PartitionSolution {

    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyHead1 = new ListNode(-1);
        ListNode low = dummyHead;
        ListNode high = dummyHead1;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val < x) {
                low.next = curr;
                low = curr;
            } else {
                high.next = curr;
                high = curr;
            }
            curr = next;

        }
        low.next = dummyHead1.next;
        return dummyHead.next;
    }

}
