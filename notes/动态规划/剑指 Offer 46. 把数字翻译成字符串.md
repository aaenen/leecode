# 剑指 Offer 46. 把数字翻译成字符串

```text
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
```

**示例 1:**

```text
输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
```

![img.png](../picts/img3.png)

```java
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            //每次都能截两个字符出来
            String tmp = s.substring(i - 2, i);
            //tmp - 10 >= 10 && tmp - 25 <= 0
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            //a 是在 b 后面-> b a c
            b = a;
            a = c;
        }
        return a;
    }
}

```
