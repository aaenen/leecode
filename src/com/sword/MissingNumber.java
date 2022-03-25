package com.sword;

import java.util.Arrays;

/**
 * 0 ～ n-1 中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class MissingNumber {
    //对于已经排好序的数组，常见的做法都是二分法
    public int missingNumber(int[] nums) {
        int right = nums.length - 1, left = 0;
        while (left < right) {
            //left + (right - left)/2 这样写可以防止 right + left 溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) {
                //此时 0 ～ mid 中已经有错了，mid 也有可能错
                right = mid;
            } else {
                //此时 0 ～ mid 都没问题，说明 mid 也没问题
                left = mid + 1;
            }
        }
        //如果从 0 ~ n-1都不缺值, 则缺少的是 n,例如输入 【1】【0】
        return (left == nums.length - 1 && nums[left] == left) ? left + 1 : left;
    }

    //方法二：理论的和减去实际的和即为缺少的数字，看起来很高级，实际上还是遍历
    public int missingNumber2(int[] nums) {
        //计算出0-n的和  n*(n+1)/2
        int sum = nums.length * (nums.length + 1) / 2;
        return sum - Arrays.stream(nums).sum();
    }
}
