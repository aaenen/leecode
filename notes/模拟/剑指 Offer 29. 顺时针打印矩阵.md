# 剑指 Offer 29. 顺时针打印矩阵

```text
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
```

**示例1：**

```text
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
```

**示例2：**

```text
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
```

```java
class Solution {

    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;
        if (col == 0) {
            return new int[0];
        }
        int[] nums = new int[row * col];
        int numsIndex = 0;
        int left = 0, top = 0, right = col - 1, bottom = row - 1;
        while (true) {
            //上面从左到右
            for (int i = left; i <= right; i++) {
                nums[numsIndex++] = matrix[top][i];
            }
            //下降一行
            if (++top > bottom) break;

            //右边从上到下
            for (int i = top; i <= bottom; i++) {
                nums[numsIndex++] = matrix[i][right];
            }
            //左退一列
            if (--right < left) break;

            //下面从右到左
            for (int i = right; i >= left; i--) {
                nums[numsIndex++] = matrix[bottom][i];
            }
            //上升一行
            if (--bottom < top) break;

            //左边从下到上
            for (int i = bottom; i >= top; i--) {
                nums[numsIndex++] = matrix[i][left];
            }
            //右进一列
            if (++left > right) break;
        }
        return nums;
    }
}
```