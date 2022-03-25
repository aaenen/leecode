package com.sword;

/**
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * <p>
 * 部分数值列举如下：
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 */
public class IsNumber {
    public boolean isNumber(String s) {
        if (s.length() == 0 || s == null) return false;
        //trim() 方法用于删除字符串的头尾空白符，空白符包括：空格、制表符 tab、换行符等其他空白符等。
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判断数字，标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
                //判断 . ，需要没出现过 . ，并且没出现过 e 。. 能在 e 前，不能在 e 后
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判断 e，需要没出现过 e，并且出过数字了
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E' && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免 123e 这种情况，出现 e 后 numFlag 置为 false ，需要下一个数字出现
                //判断 + / - 符号，只能出现在第一位或者紧跟在 e / E 后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e') || s.charAt(i - 1) == 'E') {
                //其他情况，都是非法的，这个判断语句里哪怕什么都不执行，也是要有的，不然就直接跳入下面的 else 了
            }else {
                return false;
            }
        }
        return numFlag;
    }
}
