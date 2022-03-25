package com.sword;

/**
 * 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //方法一：迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return l1;
        //new ListNode(-1) 这个才是创建一个链表，后面那个是创建一个节点
        ListNode newNode = new ListNode(-1), temp = newNode;
        while (l1 != null && l2 != null) {
            if (l2.val <= l1.val) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            } else {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
        }
        //要多用这种精简的写法啦，别老是if if的
        temp.next = (l1 == null) ? l2 : l1;
        //这里创建啦一个伪头节点，所以返回的时候从 .next开始
        return newNode.next;
    }

    //方法二：递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
