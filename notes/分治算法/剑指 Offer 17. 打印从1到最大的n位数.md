# 剑指 Offer 17. 打印从1到最大的n位数

```text
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
```

**示例1：**

```text
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
```

```java
class Solution {
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] nums = new int[end];
        for (int i = 0; i < end; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}
```
[面试题17. 打印从 1 到最大的 n 位数（分治算法)](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/)
```java
class Solution {
    //考虑大数的做法，需要用到分治
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res[count++] = Integer.parseInt(s);
            if (n - start == nine) start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}
```