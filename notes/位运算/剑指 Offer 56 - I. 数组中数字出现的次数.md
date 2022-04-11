# 剑指 Offer 56 - I. 数组中数字出现的次数

```text
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
```

**示例1：**

```text
输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
```

**示例2：**

```text
输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
```

```java
class Solution {
    public int[] singleNumbers(int[] nums) {
        //方法一：hashMap，只出现一次说明就是所求
        Map<Integer, Integer> map = new HashMap<>();
        int tmp = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int j = map.getOrDefault(nums[i], -1);
            if (j == -1) map.put(nums[i], i);
            else map.put(nums[i], -2);
        }
        for (int i = 0; i < nums.length; i++) {
            int j = map.get(nums[i]);
            if (-2 != j) {
                result[tmp++] = nums[i];
            }
        }
        return result;
    }
}
```

```java
class Solution {
    //题目要求时间复杂度 O(N) ，空间复杂度 O(1) ，因此首先排除 暴力法 和 哈希表统计法 。
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        //如果要找两个不重复的a和b，a和b一定是不一样的，一定有位是不同的，因此a和b的异或值一定存在1，然后我们从右到左找到异或值得第一个1的位置，得到一个辅助的值例如0010000，这个1就是异或值的第一个1的位置。
        for (int num : nums)               // 1. 遍历异或
            n ^= num;
        //然后用数组的每个元素和0010000做异或，a和b跟0010000做异或的值一定一个是0一个是1
        while ((n & m) == 0)               // 2. 循环左移，计算 m
            m <<= 1;
        //除了a和b以外其他的值跟0010000做异或，如果是0就跟a做异或，如果是1就跟b做异或。
        for (int num : nums) {              // 3. 遍历 nums 分组
            if ((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
            else y ^= num;                // 4. 当 num & m == 0
        }
        //最后得到的a和b就是题目要求的值
        return new int[]{x, y};          // 5. 返回出现一次的数字
    }
}
```