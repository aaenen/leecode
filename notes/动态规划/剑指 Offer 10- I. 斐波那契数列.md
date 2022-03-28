# 剑指 Offer 10- I. 斐波那契数列

```text
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.

斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
```

**示例1：**

```text
输入：n = 2
输出：1
```

**示例2**

```text
输入：n = 5
输出：5
```

```java
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        int result = 0;
        while (--n > 0) {
            result = first + second;
            if (result >= 1000000007) {
                result -= 1000000007;
            }
            first = second;
            second = result;
        }
        return result;
    }
}
```