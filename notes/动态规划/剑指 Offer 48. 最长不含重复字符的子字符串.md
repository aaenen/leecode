# 剑指 Offer 48. 最长不含重复字符的子字符串

```text
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
```

**示例1：**

```text
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

**示例2：**

```text
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    //滑动窗口，用set维护一个不重复的窗口,Hashset + 双指针
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        //用一个HashSet来保持一个最大不重复的窗口
        Set<Character> set = new HashSet<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            //当有字符重复时，把前面已经出现当到这个字符的全部删除，因为有多个，用while循环
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
```

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    //方法二：动态规划 + 哈希表
    public int lengthOfLongestSubstring(String s) {
        int tmp = 0, res = 0;
        //用Hashmap来存储，set只存一个数，map存两个
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            //获取这个char在map中的key值，没有则置为-1,
            int i = map.getOrDefault(s.charAt(j), -1);
            //更新哈希表
            map.put(s.charAt(j), j);
            //tmp是上一个j时的，此时dp[j - 1] -> dp[j]
            //这里固定的是j，当 dp[j - 1] < j - i ，说明字符 s[i] 在子字符串 dp[j−1] 区间之外 ，则 dp[j] = dp[j - 1] + 1 ；
            //当 dp[j−1] ≥ j−i ，说明字符 s[i] 在子字符串 dp[j-1] 区间之中 ，则 dp[j] 的左边界由 s[i] 决定，即 dp[j] = j - i ；
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }
}
```