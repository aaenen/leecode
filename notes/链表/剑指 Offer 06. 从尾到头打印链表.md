# 剑指 Offer 06. 从尾到头打印链表

```text
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
```

**示例 1：**

```text
输入：head = [1,3,2]
输出：[2,3,1]
```

```java
/**
 * 第一遍扫描查看有多少个元素
 * 第二遍循环用另外一个数组反过来存
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; --i) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }
}
```