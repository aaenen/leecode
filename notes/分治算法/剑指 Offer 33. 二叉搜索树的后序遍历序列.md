# 剑指 Offer 33. 二叉搜索树的后序遍历序列

```text
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：
     5
    / \
   2   6
  / \
 1   3
```

**示例1：**

```text
输入: [1,6,3,2,5]
输出: false
```

**示例2：**

```text
输入: [1,3,2,6,5]
输出: true
```

```java
class Solution {
    //方法一：递归遍历此树、此树的左子树、此树的右子树是否正确
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int left, int right) {
        //终止条件： 当 i ≥ j ，说明此子树节点数量 ≤ 1 ，无需判别正确性，因此直接返回 true ；
        //此处的 right 其实是头节点，先遍历左子树（即比头节点小的），再遍历右子树（即比头节点大的）
        if (left >= right) return true;
        int post = left;
        while (postorder[post] < postorder[right]) post++;
        int m = post;
        while (postorder[post] > postorder[right]) post++;
        // post == right 判断 此树 是否正确。
        return post == right && recur(postorder, left, m - 1) && recur(postorder, m, right - 1);
    }
}
```

```java
class Solution {
    //辅助单调栈  后序遍历倒序： [ 根节点 | 右子树 | 左子树 ] 。类似 先序遍历的镜像 ，即先序遍历为 “根、左、右” 的顺序，而后序遍历的倒序为 “根、右、左” 顺序。
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        //先假设树的根结点为无穷大∞
        int root = Integer.MAX_VALUE;
        //从后面开始遍历，即根、右子树、左子树
        for(int i = postorder.length - 1; i >= 0; i--) {
            
            if(postorder[i] > root) return false;
            //stack.peek() 方法是返回栈顶的元素但不移除它。
            //stack.pop() 方法是返回栈顶的元素并移除它。
            while(!stack.isEmpty() && stack.peek() > postorder[i])
            	root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}

```