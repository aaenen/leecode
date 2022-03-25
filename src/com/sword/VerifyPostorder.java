package com.sword;

/**
 * 二叉搜索树的后序遍历序列
 * 二叉搜索树是left < root < right
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * <p>
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 * <p>
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class VerifyPostorder {
    //方法一：递归遍历此树、此树的左子树、此树的右子树是否正确
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int left, int right) {
        //终止条件： 当 i ≥ j ，说明此子树节点数量 ≤ 1 ，无需判别正确性，因此直接返回 true ；
        if (left >= right) return true;
        int post = left;
        while (postorder[post] < postorder[right]) post++;
        int m = post;
        while (postorder[post] > postorder[right]) post++;
        // post == right 判断 此树 是否正确。
        return post == right && recur(postorder, left, m - 1) && recur(postorder, m, right - 1);
    }

    //方法二：
}
