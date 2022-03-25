package com.sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树ii
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrderRow {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //I. 按层打印： 题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。BFS 通常借助 队列 的先入先出特性来实现。
    //II. 每层打印到一行： 将本层全部节点打印到一行，并将下一层全部节点加入队列，以此类推，即可分为多行打印。
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        //特例处理： 当根节点为空，则返回空列表 [] ；
        if (root != null) queue.add(root);
        //初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
        //BFS 循环： 当队列 queue 为空时跳出；
        while (!queue.isEmpty()) {
            //新建一个临时列表 tmp ，用于存储当前层打印结果；
            List<Integer> tmp = new ArrayList<>();
            //当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）；
            //关键点就在这里，这里判断每一层的长度，一层一层来操作，分层的关键
            for (int i = queue.size(); i > 0; i--) {
                //出队： 队首元素出队，记为 node；
                //打印： 将 node.val 添加至 tmp 尾部；
                TreeNode node = queue.poll();
                tmp.add(node.val);
                //添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
                //将当前层结果 tmp 添加入 res 。
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            //返回值： 返回打印结果列表 res 即可。
            res.add(tmp);
        }
        return res;
    }
}
