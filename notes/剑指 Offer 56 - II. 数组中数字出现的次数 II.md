# 剑指 Offer 56 - II. 数组中数字出现的次数 II

```text
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
```

**示例1：**

```text
输入：nums = [3,4,3,3]
输出：4
```

**示例2：**

```text
输入：nums = [9,1,7,9,7,9,7]
输出：1
```

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = res.getOrDefault(nums[i], 0);
            res.put(nums[i], a + 1);
        }
        //既然已经存入map里面了，直接从map里面调用会更快一点点
        for (Integer a : res.keySet()) {
            if (res.get(a) == 1) return a;
            return -1;
        }
    }
}
```