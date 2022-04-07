# 剑指 Offer 16. 数值的整数次方

```text
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
```

**示例1：**

```text
输入：x = 2.00000, n = 10
输出：1024.00000
```

**示例2：**

```text
输入：x = 2.10000, n = 3
输出：9.26100
```

```java
class Solution {
    //常规的暴力解决会爆时间
    //由于每次递归都会使得指数减少一半，因此递归的层数为 O(logn)，算法可以在很快的时间内得到结果。
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
}
```