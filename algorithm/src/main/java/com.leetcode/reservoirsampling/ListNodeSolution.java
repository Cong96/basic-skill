package com.leetcode.reservoirsampling;

import com.datastructure.linkedlist.ListNode;

import java.util.Random;

/**
 * @Author: BryantCong
 * @Date: 2020/1/19 15:21
 * @Description:
 *
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 *
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-random-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ListNodeSolution {


    private ListNode head;

    public static void main(String[] args) {

    }
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public ListNodeSolution(ListNode head) {
        this.head=head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random r = new Random();

        ListNode p=head;
        ListNode result=null;
        int n = 0;
        while(p!=null){
            n++;
            //我们以1/n的概率留下该数据
            if(r.nextInt() % n == 0) result = p;
            p=p.next;
        }
        return result.val;


    }

}
