package com.sword;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 输入：[2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制：2 <= n <= 100000
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(findRepeatNumber(nums));
    }

    private static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return -1;
    }
}
