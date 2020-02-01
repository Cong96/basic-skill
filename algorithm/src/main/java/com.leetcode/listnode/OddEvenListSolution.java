package com.leetcode.listnode;

import com.datastructure.linkedlist.ListNode;

/**
 * @ClassName OddEvenListSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 1:09
 * @Version V1.0
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class OddEvenListSolution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        head.next = l1;
        ListNode l2 = new ListNode(3);
        l1.next = l2;
        ListNode l3 = new ListNode(4);
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        l3.next = l4;
        ListNode l5 = new ListNode(6);
        l4.next = l5;
        ListNode l6 = new ListNode(7);
        l5.next = l6;
        ListNode l7 = new ListNode(8);
        l6.next = l7;
        OddEvenListSolution oddEvenListSolution = new OddEvenListSolution();
        ListNode res = oddEvenListSolution.oddEvenList(head);
        System.out.println(res.val);

    }


    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = new ListNode(-1);
        ListNode oddHead = new ListNode(-1);
        ListNode odd = oddHead;
        ListNode even = evenHead;
        ListNode curr = head;
        int i = 1;
        while (curr != null) {
            if (i % 2 == 1) {
                ListNode next = curr.next;
                odd.next = curr;
                //切断与原链表的联系
                curr.next = null;
                odd = odd.next;
                curr = next;
            } else {
                ListNode next = curr.next;
                even.next = curr;
                curr.next = null;
                even = even.next;
                curr = next;
            }
            i++;
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }
}
