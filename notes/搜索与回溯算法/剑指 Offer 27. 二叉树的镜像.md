# 剑指 Offer 27. 二叉树的镜像
```text
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9

镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
```
**示例1：**
```text
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
```
```java
public class MirrorTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //方法一：递归
    //我们从根节点开始，递归地对树进行遍历，并从叶子节点先开始翻转得到镜像。
    // 如果当前遍历到的节点 root 的左右两棵子树都已经翻转得到镜像，
    // 那么我们只需要交换两棵子树的位置，即可得到以 root 为根节点的整棵子树的镜像。
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
```