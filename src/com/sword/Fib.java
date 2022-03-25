package com.sword;

import java.util.Scanner;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 输入：n = 5
 * 输出：5
 */
public class Fib {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.next());
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        //此方法比较浪费内存
//        int[] nums = new int[n+1];
//        if (n <=1) return n;
//        else {
//            nums[0] = 0;
//            nums[1] = 1;
//        }
//        for (int i = 1; i < n; i++) {
//            nums[i+1] += nums[i] + nums[i - 1];
//            nums[i+1] %= 1000000007;
//        }
//        return nums[n];
//    }
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        int result = 0;
        while (--n > 0) {
            result = first + second;
            if (result >= 1000000007) {
                result -= 1000000007;
            }
            first = second;
            second = result;
        }
        return result;
    }
}
