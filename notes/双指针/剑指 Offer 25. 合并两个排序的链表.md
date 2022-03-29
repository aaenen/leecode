# 剑指 Offer 25. 合并两个排序的链表

```text
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
```

**示例1：**

```text
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return l1;
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
        temp.next = (l1 == null) ? l2 : l1;
        return newNode.next;

    }
}
```