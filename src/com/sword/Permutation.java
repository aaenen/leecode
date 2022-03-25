package com.sword;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 字符串的排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Permutation {
    public String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        char[] arr = s.toCharArray();
        boolean[] isVisit = new boolean[arr.length];
        dfs(arr, "", isVisit, list);
        return list.toArray(new String[list.size()]);
    }

    public void dfs(char[] arr, String s, boolean[] isVisit, Set<String> list) {
        //表示 s 的长度和 arr 的长度一样，已经有成功的了
        if (arr.length == s.length()) {
            list.add(s);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (isVisit[i]) continue;
            isVisit[i] = true;
            //String.valueOf(char c) : 将 char 变量 c 转换成字符串
            dfs(arr, s + String.valueOf(arr[i]), isVisit, list);
            isVisit[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permutation2("abc"));
    }
    static List<String> res = new LinkedList<>();
    static char[] c;

    public static String[] permutation2(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    static void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            //Set.contains() 方法判断 Set 集合是否包含指定的对象。该方法返回值为 boolean 类型，如果 Set 集合包含指定的对象，则返回 true，否则返回 false。
            if (set.contains(c[i])) continue; // 重复，因此剪枝
            //Set.add() 方法用来向 Set 集合添加对象.
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }

    static void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
