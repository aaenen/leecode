# 剑指 Offer 35. 复杂链表的复制
```text
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
```
**示例1：**
![img.png](../picts/img.png)
```text
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
```
**示例2：**
![img.png](../picts/img2.png)
```text
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
```
```java
public class CopyRandomList {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //方法一：迭代+结点拆分
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //第一次遍历，复制每一个Node的next
        for (Node node = head; node != null; node = node.next.next) {
            //每次生成的都是一个新的nodeNew
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        //第二次遍历，复制每个Node的radom
        for (Node node = head; node != null; node = node.next.next) {
            //每次生成的nodeNew都是复制品的node
            Node nodeNew = node.next;
            //node的radom可能是null，因此要用三元判断法先判断一下
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node nodeHead = head.next;
        //这一次遍历是删除原本每一个node的next和radom
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return nodeHead;
    }

    /**
     * 方法二：回溯+哈希表
     * 我们用哈希表记录每一个节点对应新节点的创建情况。遍历该链表的过程中，我们检查「当前节点的后继节点」和
     * 「当前节点的随机指针指向的节点」的创建情况。如果这两个节点中的任何一个节点的新节点没有被创建，我们都立刻递归地进行创建。
     * 当我们拷贝完成，回溯到当前层时，我们即可完成当前节点的指针赋值。注意一个节点可能被多个其他节点指向，因此我们可能递归地
     * 多次尝试拷贝某个节点，为了防止重复拷贝，我们需要首先检查当前节点是否被拷贝过，如果已经拷贝过，我们可以直接从哈希表中取出
     * 拷贝后的节点的指针并返回即可。
     */
    //创建一个hashMap
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        //containsKey（head）测试是否存在于此映射中的键 如果此映射包含指定键的映射关系，则返回 true
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList2(head.next);
            headNew.random = copyRandomList2(head.random);
        }
        return cachedNode.get(head);
    }
}
```