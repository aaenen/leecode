# 剑指 Offer 18. 删除链表的节点

```text
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。
注意：此题对比原题有改动
```

**示例1：**

```text
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
```

**示例2：**

```text
输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
```

```java
//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        //首先判断head是否为空
        if (head == null) return head;
        ListNode cur = head, prev = null;
        //接下来判断val是否在第一个节点
        if (head.val == val) return head.next;
        while (cur.val != val) {
            prev = cur;
            cur = cur.next;
        }
        //通过两个节点来改变链表，而不是复制一个链表来操作，return head才是return链表
        prev.next = cur.next;
        return head;
    }
}
```

```java
//单指针版本，但是说实话没有双指针简洁易懂
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
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
```