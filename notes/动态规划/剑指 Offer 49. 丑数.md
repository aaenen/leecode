# 剑指 Offer 49. 丑数

```text
我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
```

**示例1：**

```text
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
```

```java
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        //一共有 10 个数，进行 10 次循环，每次循环取其中最小的数
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            //每次传入 dp[i] 的是三个丑数中最小的那个 
            dp[i] = Math.min(Math.min(num2, num3), num5);
            //每一个数都需要 *2、3、5，会得出来很多丑数，但只有前 n 个会被存进去，因此进行 10 次循环
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
```