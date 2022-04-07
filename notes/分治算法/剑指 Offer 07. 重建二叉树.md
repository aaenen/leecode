# 剑指 Offer 07. 重建二叉树

```text
输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
```

**示例1：**
![img.png](../picts/img07.png)

```text
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
```

**示例2：**

```text
Input: preorder = [-1], inorder = [-1]
Output: [-1]
```

```java

public class BuildTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int[] preirders = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            preirders[i] = Integer.parseInt(strings[i]);
        }
        Scanner sc2 = new Scanner(System.in);
        String[] strings2 = sc2.nextLine().split(" ");
        int[] inorder = new int[strings2.length];
        for (int i = 0; i < strings2.length; i++) {
            inorder[i] = Integer.parseInt(strings2[i]);
        }
        //System.out.print(buildTree(preirders, inorder));
    }


    //Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        //找出头节点
        int rootval = preorder[0], rootIndex = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == rootval) {
                rootIndex = i + 1;
                break;
            }
        }
        /*
         * Arrays.copyOfRange(T[] original, int from, int to) 方法复制指定的数组到一个新的数组。
         * 其中T[] original是要复制的数组，from是复制开始位置的元素的序号（包括这个元素），
         * to复制结束位置的序号（不包括这个元素）。
         */
        TreeNode root = new TreeNode(rootval);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex - 1));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n), Arrays.copyOfRange(inorder, rootIndex, n));
        return root;
    }
}
```