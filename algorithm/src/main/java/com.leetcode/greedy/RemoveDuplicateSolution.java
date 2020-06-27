package com.leetcode.greedy;

import com.datastructure.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateSolution {
    public ListNode removeDuplicateNodes(ListNode head) {
        //
        if (head == null) {
            return null;
        }
        Set<Integer> nodeSet = new HashSet<>();
        nodeSet.add(head.val);
        ListNode pre = head;
        while (pre.next != null) {
            ListNode curr = pre.next;
            if (nodeSet.add(curr.val)) {
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }

        return head;
    }

}
