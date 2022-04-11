package com.sword;

public class Main {
    public static void main(String[] args) {
        /**
         * 题目描述：
         * 第一行输入个数N，之后N行每行都表示区间，求合并区间总长度。
         * 举例：
         * 3
         * 2 4
         * 3 7
         * 8 10
         * 输出：
         * 7
         * 注意：[2,4]和[3,7]合并为[2,7],[8,10]和[2,7]没有交集，所以长度为：5+2=7；
         */
        int n = 3;
        int[][] nums = new int[n][n];
        int target = nums[0][1] - nums[0][0];
        for (int i = 1; i < n; i++) {
            int left = nums[i][0];
            int right = nums[i][1];
            if(nums[i][0] < nums[i - 1][1]){
                left = nums[i - 1][1];
            }
            target += right - left;
        }
    }
}
