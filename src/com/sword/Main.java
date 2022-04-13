package com.sword;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        System.out.println(toHex(nums));
    }

    public static int toHex(int num) {
        if (num == 0) {
            return 0;
        }
        int target = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i--) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                if (val >= 10) target++;
                sb.append(digit);
            }
        }
        return target;
    }
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
     * int n = 3;
     *         int[][] nums = new int[n][n];
     *         int target = nums[0][1] - nums[0][0];
     *         for (int i = 1; i < n; i++) {
     *             int left = nums[i][0];
     *             int right = nums[i][1];
     *             if (nums[i][0] < nums[i - 1][1]) {
     *                 left = nums[i - 1][1];
     *             }
     *             target += right - left;
     */
}
