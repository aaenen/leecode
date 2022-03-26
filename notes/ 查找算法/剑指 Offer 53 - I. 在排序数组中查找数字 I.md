# 剑指 Offer 53 - I. 在排序数组中查找数字 I
```text
统计一个数字在排序数组中出现的次数。
```
**示例1：**
```text
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
```
**示例2：**
```text
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
```
**这道题主要还是考察二分法**
```java
public class Serch {
    //那么多种查找法中，折半查找法效率是最高的
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int count = 0;
        while (left <= right) {
            //这样找中间的值可以有效避免数据爆了
            int mid = left + (right - left) / 2;
            //先找到target，再向两边扩散找，这样的效率肯定是比下面的两边向target找快的
            if (nums[mid] == target) {
                count++;
                right = mid + 1;
                left = mid - 1;
                while (right < len && nums[right] == target) {
                    count++;
                    right++;
                }
                while (left >= 0 && nums[left] == target) {
                    count++;
                    left--;
                }
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return count;
    }

    //找到target后，两边向中间找
    public int search2(int[] nums, int target) {
        int len = nums.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                if (nums[hi] != target)
                    hi--;
                else if (nums[lo] != target)
                    lo++;
                else
                    break;
            }
        }
        return hi - lo + 1;
    }
}
```