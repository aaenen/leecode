package com.sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * [3,9,20,15,7]
 */
public class LevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        //题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
        //BFS 通常借助 队列 的先入先出特性来实现。
        public int[] levelOrder(TreeNode root) {
            if (root == null) return new int[0];
            Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
                add(root);
            }};
            ArrayList<Integer> ans = new ArrayList<>();
            while (!queue.isEmpty()) {
                //poll()方法获取并删除Queue中的第一个元素。
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            int[] res = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++)
                res[i] = ans.get(i);
            return res;
        }
    }
}
