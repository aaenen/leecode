package com.sword;

/**
 * 树的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 *      3
 *    / \
 *   4   5
 *  / \
 * 1   2
 * 给定的树 B：
 *   4
 *  /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 */
public class IsSubStructure {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //遇到树🌲的题目是一定要递归的
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null) return false;
        if (B == null) return false;
        return dfs(A, B) && isSubStructure(A.left, B) && isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        if (A == null) return false;
        if (B == null) return true;
        return A.val == B.val && dfs(A.left, B.right) && dfs(A.right, B.left);
    }

}
