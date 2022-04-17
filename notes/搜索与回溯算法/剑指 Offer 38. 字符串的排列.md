# 剑指 Offer 38. 字符串的排列

```text
输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
```

**示例1：**

```text
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
```

```java
class Solution {
    List<String> res = new LinkedList<>();
    //把 c 定义在这里就不用传了
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
```

```java
class Solution {

    /**
     该题类似于 全排列2，本题使用set来去除重复元素
     除了使用set去重外，还可以对数组进行排序，使用visited数组进行剪枝！
     */
    Set<String> res = new HashSet();

    public String[] permutation(String s) {
        backtrack(s.toCharArray(), new StringBuilder(), new boolean[s.length()]);
        return res.toArray(new String[0]);

    }

    // 回溯函数
    public void backtrack(char[] ch, StringBuilder sb, boolean[] visitid) {
        // 终止条件
        if (sb.length() == ch.length) {
            res.add(sb.toString());
            return;
        }
        // 选择列表
        for (int i = 0; i < ch.length; i++) {
            // 剪枝，如果当前位置的元素已经使用过，则跳过进入下一个位置
            if (visitid[i]) continue;
            // 做出选择
            sb.append(ch[i]);
            // 更新标记
            visitid[i] = true;
            // 进入下层回溯
            backtrack(ch, sb, visitid);
            // 撤销选择
            sb.deleteCharAt(sb.length() - 1);
            visitid[i] = false;

        }
    }
}
```