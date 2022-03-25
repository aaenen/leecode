package com.sword;

/**
 * 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class DeleteNode {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //删除1个结点在考研的时候练过那么多次，还是不能一次写出来
    public ListNode deleteNode(ListNode head, int val) {
        //边界值非空判断
        if (head == null) return head;
        //创建双指针
        ListNode cur = head, prev = null;
        //循环的条件，一气呵成
        if (val == head.val) {
            return head.next;
        }
        //
        while (cur.val != val) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = prev.next.next;
        //return head； 的话才是return一整个链表，return prev；的话只是 return 了一个节点
        return head;
    }

    //单指针版本，这道题的判断条件是 .val ，还是没仔细读题目啊
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val)
            cur = cur.next;
        if (cur.next != null)
            cur.next = cur.next.next;
        return head;
    }
}
