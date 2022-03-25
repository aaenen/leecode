package com.sword;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 剪绳子 数学推导/动态规划
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大
 * 乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的
 * 最大乘积是18。
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class CuttingRope {
    //方法一 数学推导,贪心算法
    //推论一： 将绳子 以相等的长度等分为多段 ，得到的乘积最大。
    //推论二： 尽可能将绳子以长度 33 等分为多段时，乘积最大。
    //切分规则：
    //最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况。
    //次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1 。
    //最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3+1 替换为 2+2，因为 2×2 > 3×1。
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        //pow() 该函数返回 x 的 y 次幂的结果。
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    //方法二 动态规划
    //其实就是两个for循环遍历
    public int cuttingRope2(int n) {
        int[] dp = new int[n+1];
        int nowBigger;
        dp[2] = 1;
        //如果只减掉长度为1，对最后的乘积无任何影响，所以从长度为2开始减
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 剪了第一段后，剩下(i - j)长度可以剪也可以不剪。如果不剪的话长度乘积即为j * (i - j)；如果剪的话长度乘积即为j * dp[i - j]。取两者最大值
                nowBigger = Math.max(j * (i - j), j * dp[i - j]);
                // 对于同一个i，内层循环对不同的j都还会拿到一个max，所以每次内层循环都要更新max
                dp[i] = Math.max(dp[i], nowBigger);
            }
        }
        return dp[n];
    }

    //题目➕要求了，答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
    //思路和上面一样，只是把求最大值和求模写成大数的运算
    //如果在操作的时候一个整型数据已经超过了整数的最大类型长度long的话，则此数据就无法装入，所以，此时要使用BigInteger类进行操作。
    //multiply（）该方法返回一个BigInteger对象的值是 this * val.
    //valueOf（）valueOf() 方法用于返回给定参数的原生 Number 对象值，参数可以是原生数据类型, String等。
    //intValue（）输出int数据。
    public int cuttingRope3(int n) {
        BigInteger dp[] = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return  dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

}
