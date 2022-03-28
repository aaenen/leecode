# 剑指 Offer 04. 二维数组中的查找
```text
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
```
**示例**
```text
现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```
```text
给定 target = 5，返回 true。
给定 target = 20，返回 false。
```

```java
class Solution {
    //同样是遍历，但是要根据题目给的条件，从右上角开始找会更快，大了向下一行，小了向左一列
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while ( matrix.length > i && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            }
        }
        return false;
    }
}
```