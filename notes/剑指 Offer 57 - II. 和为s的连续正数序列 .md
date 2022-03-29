# 剑指 Offer 57 - II. 和为s的连续正数序列

```text
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
```

**示例1：**

```text
输入：target = 9
输出：[[2,3,4],[4,5]]
```

**示例2：**

```text
输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
```

```java
class Solution {
    //数组里面的数是有序的，可以用快慢指针一个一个找
    //要读懂题目啊，题目是给定一个 target，让你从整数里面找一个连续序列 =target，所以找到 target/2
    //时还没有的话就不用再找了，后面的任意两个数相加必大于target
    public int[][] findContinuousSequence(int target) {
        //要输出一个二维数组，每次保存都是保存一个一维数组
        List<int[]> res = new ArrayList<>();
        int left = 1, right = 1, sum = 0;
        while (left <= target / 2) {
            //sum < target 说明连续的数不够 target 大，需要增大一个 right
            if (sum < target) {
                sum += right;
                right++;
            }
            //sum > target 说明连续的数比 target 大，需要增大一个 left
            else if (sum > target) {
                sum -= left;
                left++;
            }
            //来整理输出
            else {
                int[] nums = new int[right - left];
                for (int i = left, j = 0; i < right; i++) {
                    nums[j++] = i;
                }
                res.add(nums);
                //此时的left已经符合，向右移动一格
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[][]{});
    }
}
```