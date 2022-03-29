package com.sword;

import java.util.HashMap;
import java.util.Map;


class Solution {
    public int[] singleNumbers(int[] nums) {
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
