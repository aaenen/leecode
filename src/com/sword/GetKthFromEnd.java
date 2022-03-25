package com.sword;

/**
 * 链表中倒数第 k 个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class GetKthFromEnd {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            //快慢指针，先让快指针走k步，然后两个指针同步走，当快指针走到头时，慢指针就是链表倒数第k个节点。
            //这是链表，不能直接 head.length() 求长度的
            ListNode fastNode = head, lowNode = head;
            for (int i = 0; i < k; i++) {
                //更健壮一点的写法应该是这样 while (fastNode.next != null && k > 0)
                fastNode = fastNode.next;
            }
            while (fastNode.next != null) {
                fastNode = fastNode.next;
                lowNode = lowNode.next;
            }
            return lowNode;
        }
    }
}
