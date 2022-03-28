# 剑指 Offer 50. 第一个只出现一次的字符

```text
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
```

**示例1：**

```text
输入：s = "abaccdeff"
输出：'b'
```

**示例2：**

```text
输入：s = "" 
输出：' '
```

```java
class Solution {
    // 计数数组，第一个只出现一次的字符，怎么也得遍历一次的
    public char firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) count[c - 'a']++;
        for (char c : chars) {
            if (count[c - 'a'] == 1) return c;
        }
        return ' ';
    }
}
```

```java
import java.util.HashMap;

//哈希表
//遍历字符串 s ，使用哈希表统计 “各字符数量是否 >1 ”。
//再遍历字符串 s ，在哈希表中找到首个 “数量为 1 的字符”，并返回。
class Solution {
    public char firstUniqChar(String s) {
        HashMap<Integer, boolean> dic = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) dic.put(c, !dic.containsKey(c));
        for (char c : chars) {
            if (dic.get(c)) return c;
        }
        return ' ';
    }
}
```

```java
//有序哈希表
//在哈希表的基础上，有序哈希表中的键值对是 按照插入顺序排序 的。基于此，可通过遍历有序哈希表，实现搜索首个 “数量为 1 的字符”。
//哈希表是 去重 的，即哈希表中键值对数量 ≤ 字符串 s 的长度。因此，相比于方法一，方法二减少了第二轮遍历的循环次数。当字符串很长（重复字符很多）时，方法二则效率更高。
//Java 使用 LinkedHashMap 实现有序哈希表。
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        //Map的entrySet()方法返回一个实现Map.Entry接口的对象集合。
        //Map.Entry是为了更方便的输出map键值对。
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            //Object getKey(): 返回条目的关键字
            //Object getValue(): 返回条目的值
            if (d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
```