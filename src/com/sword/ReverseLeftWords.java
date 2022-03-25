package com.sword;

/**
 * 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class ReverseLeftWords {
    //方法一：字符串切片
    //把字符串在n处切成前后两部分，然后再把这两部分拼在一起
    public String reverseLeftWords(String s, int n) {
        //substring(int beginIndex, int endIndex)返回字符串的子字符串
        //beginIndex -- 起始索引（包括）, 索引从 0 开始。
        //endIndex -- 结束索引（不包括）。
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    //方法二：整体反转+局部反转
    //1.反转区间为前n的子串
    //2.反转区间为n到末尾的子串
    //3.反转整个字符串

    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        System.out.println(reverseLeftWords2(s, n));
    }
    public static String reverseLeftWords2(String s, int n) {
        int len=s.length();
        StringBuilder sb=new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,len-1);
        //reverse() 方法反转数组中元素的顺序。第三次反转
        return sb.reverse().toString();
    }
    public static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            //charAt(int i)方法返回字符串指定位置i的字符
            //setCharAt（int i,char b）将字符串第i个位置字符改为b
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

}
