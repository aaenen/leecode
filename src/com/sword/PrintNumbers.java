package com.sword;

/**
 * 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 */
public class PrintNumbers {
    //这道题如果不考虑大数问题，一点意义都没有，唯一的亮点就是用pow（）求10的幂次方，api高手
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n);
        int[] print = new int[end - 1];
        for (int i = 0; i < end; i++) {
            print[i] = i + 1;
        }
        return print;
    }

    //考虑大数情况，在数字很大的情况下，哪怕long类型也无法承载，那必须要用到字符串保存
    //对于本题其实就是对数字0~9的全排列，从1位数0~9的全排列到n位数0~9的全排列，其中要注意的是数字开头不应该有0。
    StringBuilder res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String printNumbers2(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        //start 表示最开始的 1 前面有几个 0
        start = n - 1;
        //0 相当于最高位，n-1 相当于最低位。当 x = n 时得到一个结果
        dfs(0);
        //删除最后一个逗号
        //deleteCharAt（int i）删除第i个字符
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    void dfs(int x) {
        //当 x = n 时代表已经得到一个长为 n 当数字字符串
        if (x == n) {
            //将字符数组转换为字符串，substring(start)代表去掉前面start个0
            //valueOf() 方法用于返回给定参数的原生 Number 对象值
            String s = String.valueOf(num).substring(start);
            //输出是从 1 开始的，如果当前的结果是 0，则去掉此结果。
            if (!s.equals("0")) res.append(s).append(",");
            //如果当前的 s == "009" ，之后的输出是从 010 开始，前面 0 的个数少了一个，因此 start 减 1
            if (n - start == nine) start--;
            return;
        }
        for (char i : loop) {
            //nine 用于统计当前的数中 9 的个数
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        //此处相当于从 001 到 009 已经输出完毕，下一个是 010 ，因此数中 9 的个数减少 1
        nine--;
    }
}


