package com.leetcode.listnode;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName SortListSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 23:00
 * @Version V1.0
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SortListSolution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //边界条件
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode right = sortList(head);
        ListNode left = sortList(temp);
        ListNode dummyHead = new ListNode(-1);
        ListNode h = dummyHead;
        while (right != null && left != null) {
            if (right.val > left.val) {
                h.next = left;
                left = left.next;
                h = h.next;
            } else {
                h.next = right;
                right = right.next;
                h = h.next;
            }
        }
        h.next = left == null ? right : left;

        return dummyHead.next;
    }
}
