package com.sword;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 * <p>
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class MinNumber {
    //此题求拼接起来的最小数字，本质上是一个排序问题。设数组 nums 中任意两数字的字符串为 x 和 y ，则规定 排序判断规则 为：
    //若拼接字符串 x + y > y + x ，则 x “大于” y ；
    //反之，若 x + y < y + x ，则 x “小于” y ；

    //方法一：采用快排
    public String minNumber(int[] nums) {
        //初始化： 字符串列表 strsstrs ，保存各数字的字符串格式；
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    void quickSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }

    //方法二：内置函数
    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        //返回参与比较的前后两个字符串的ASCII码的差值，
        //sort(T[] a, Comparator<? supre T> c)根据指定比较器产生的顺序对指定对象数组进行排序。
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
