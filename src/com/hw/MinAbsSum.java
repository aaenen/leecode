package com.hw;

import java.util.Scanner;

/**
 * 给定一个随机的整数（可能存在正整数和负整数）数组nums，请你在该数组中找出两个数，其和的绝对值（｜nun［x］+num［y］为最小值，
 * 并返回这两个数（按从小到大返回））以及绝对值
 * 每种输入只会对应一个答案，但是，数组中同一个元素不能使用两遍
 * 输入描述：一个通过空格分割的有序整数字符串，最多1000和。-1 -3 7 5 11 11
 * 输出描述：两数之和绝对值最小值 -3 5 2
 */
public class MinAbsSum {
    public static void main(String[] args) {
        //这一段几乎是标配了，处理输入的数据
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int nums[] = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        //通过两个for循环进行暴力遍历，得出想要的结果
        int[] res = minAbsSum(nums);
        //按照题目要求输出
        for (int i = 0; i < res.length; i++) {
            //最后一个输出结果，不用加空格
            if (i == res.length - 1) {
                System.out.print(res[i]);
            }else {
                System.out.print(res[i] + " ");
            }
        }
    }
    private static int[] minAbsSum(int[] nums) {
        if (nums.length < 2) {
            return null;
        }
        //假设第一二个就是所要
        int min = Math.abs(nums[0] + nums[1]);
        int x = nums[0];
        int y = nums[1];
        //两个for循环遍历所有情况
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++)
                if (Math.abs(nums[i] + nums[j]) < min) {
                    min = Math.abs(nums[i] + nums[j]);
                    //判断两个数孰大孰小，小的在前
                    x = Math.min(nums[i], nums[j]);
                    y = Math.max(nums[j], nums[i]);
                }
        }
        return new int[] {x, y, min};
    }
}
