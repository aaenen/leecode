# 剑指 Offer 61. 扑克牌中的顺子

```text
从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
```

**示例1：**

```text
输入: [1,2,3,4,5]
输出: True
```

**示例2：**

```text
输入: [0,0,1,2,5]
输出: True
```

```java
import java.util.Arrays;

class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) tmp++;
            else {
                if (tmp > 2) return false;
                if(nums[i])
            }

        }

    }
}
```