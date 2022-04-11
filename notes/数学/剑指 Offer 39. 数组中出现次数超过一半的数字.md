# 剑指 Offer 39. 数组中出现次数超过一半的数字

```text
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。
```

**示例1：**

```text
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
```

```java
class Solution {
    //该数出现过一半，那么排序后的中位数必定是该数
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
```

```java
//方法二：哈希表
```

```java
class Solution {
    //摩尔投票法，本质上是让众数和非众数互相抵消，到最后剩下的就是众数
    //推论一： 若记 众数 的票数为 +1 ，非众数 的票数为 −1 ，则一定有所有数字的 票数和 >0 。
    //推论二： 若数组的前 a 个数字的 票数和 =0 ，则 数组剩余 (n-a) 个数字的 票数和一定仍 >0 ，即后 (n−a) 个数字的 众数仍为 x 。
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        //当 票数 votes 等于 0 ，则假设当前数字 num 是众数；
        //当 num = x 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1 ；
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
```