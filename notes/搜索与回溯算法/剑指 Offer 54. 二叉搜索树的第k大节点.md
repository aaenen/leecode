# 剑指 Offer 54. 二叉搜索树的第k大节点

```text
给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
```

**示例1：**

```text
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
```

**示例2：**

```text
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
```

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //方法一：中序遍历存到list里面，然后返回 length - k 的结点
    public int kthLargest(TreeNode root, int k) {
        //二叉搜索树的中序遍历是递增序列
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        //
        return list.get(list.size() - k);
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) helper(root.left, list);
        list.add(root.val);
        if (root.right != null) helper(root.right, list);
    }
}
```

```java
class Solution {
    //方法二：直接反过来存，然后找到第 k 个时候退出循环
    private int ans = 0, count = 0;

    public int kthLargest(TreeNode root, int k) {
        // clarification:  root == null?   k <= 1?
        helper(root, k);
        return ans;
    }

    private void helper(TreeNode root, int k) {
        //注意是第K大，所以右根左；第K小才是左根右
        if (root.right != null) helper(root.right, k);

        if (++count == k) {
            ans = root.val;
            return;
        }

        if (root.left != null) helper(root.left, k);
    }
}
```