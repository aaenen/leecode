package com.sword;

/**
 * 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 */
public class MyPow {
    public double myPow(double x, int n) {
        //作为一名程序员，要什么情况都考虑到
        //0的正数次方等于0;0的非正数次方(0次方和负数次方)无意义,因为0不能做分母。
        //可以加一个判断if（x == 0）return 0；
        if(x == 0) return 0;
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        //再算幂次的时候，x^4 = 2 * x^2
        double half = myPow(x, n / 2);
        //mod 用来解决奇数和偶数问题，其实最后结果只有1，就是多✖️一次x
        double mod = myPow(x, n % 2);
        //用递归的方法确实比for好用很多
        return half * half * mod;
    }
}
