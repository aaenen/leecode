package com.sword;

/**
 * 1～n 整数中 1 出现的次数
 * <p>
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * 输入：n = 12
 * 输出：5
 */
public class CountDigitOne {
    public int countDigitOne(int n) {
        //初始时digit是个位
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        //当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
        while (high != 0 || cur != 0) {
            //cur == 0 即 x0x
            if (cur == 0) res += high * digit;
                //cur = 1 即 x1x 或者 1x
            else if (cur == 1) res += high * digit + low + 1;
                //其他情况，xxx 或者 x
            else res += (high + 1) * digit;
            //将 cur 加入 low ，组成下轮 low
            low += cur * digit;
            //下轮 cur 是本轮 high 的最低位
            cur = high % 10;
            //将本轮 high 最低位删除，得到下轮 high
            high /= 10;
            //位因子每轮 × 10
            digit *= 10;
        }
        return res;
    }
}
