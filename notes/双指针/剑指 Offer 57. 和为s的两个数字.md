# 剑指 Offer 57. 和为s的两个数字

```text
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
```

**示例1：**

```text
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
```

**示例2：**

```text
输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]
```

```java
//方法一：set 数组只用遍历一次，但是这个返回很有技巧，可以学习一下
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (res.contains(target - num)) {
                return new int[]{num, target - num};
            } else {
                res.add(num);
            }
        }
        return new int[]{};
    }
}
```

```java
//方法二：一前一后双指针
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) i++;
            else if (s > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }
}
```