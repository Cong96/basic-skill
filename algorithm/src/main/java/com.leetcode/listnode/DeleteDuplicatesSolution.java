package com.leetcode.listnode;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName DeleteDuplicatesSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 23:00
 * @Version V1.0
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class DeleteDuplicatesSolution {
    public ListNode deleteDuplicates(ListNode head) {
        //审题，排序列表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        //如果只有1个节点，那么不存在重复，只有至少两个节点的时候，才会出现
        while (cur.next != null && cur.next.next != null) {
            if (cur.val == cur.next.val) {
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                //将相等的节点全部删除掉
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
