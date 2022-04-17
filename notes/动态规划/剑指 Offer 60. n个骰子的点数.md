# 剑指 Offer 60. n个骰子的点数

```text
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
```

**示例1：**

```text
输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
```

**示例2：**

```text
输入: 2
输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
```

```java
class Solution {
    //用的是每一种状态出现的量去 ➗ 总的量
    public double[] dicesProbability(int n) {
        // 总的状态数为6 * n，bp[0]不使用
        int[] dp = new int[6 * n + 1];
        // 总的次数
        double all = Math.pow(6, n);

        //阶段1的状态
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            // 阶段i的状态，与阶段i-1的状态有关系，所以j从i*6开始
            for (int j = i * 6; j >= i; j--) {
                dp[j] = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j - k < i - 1) break;
                    dp[j] += dp[j - k];
                }
            }
        }

        double[] ans = new double[6 * n - n + 1];
        // 计算概率
        for (int i = n; i <= n * 6; i++) {
            ans[i - n] = dp[i] / all;
        }

        return ans;
    }
}
```