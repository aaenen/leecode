package com.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * <p>
 * 输入：s = ""
 * 输出：' '
 */
public class FirstUniqChar {
    //方法一：使用哈希表存储频数。我们可以对字符串进行两次遍历。
    //在第一次遍历时，我们使用哈希映射统计出字符串中每个字符出现的次数。在第二次遍历时，
    // 我们只要遍历到了一个只出现一次的字符，那么就返回该字符，否则在遍历结束后返回空格。
    public char firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    //方法二：利用数组、字符求解
    //感觉都是要用两次遍历的
    public char firstUniqChar2(String s){
        int[] count = new int[26];
        //toCharArray() 方法将字符串转换为字符数组。
        char[] chars = s.toCharArray();
        for(char c : chars) count[c - 'a']++;
        for (char c : chars){
            if (count[c] == 1) return c;
        }
        return ' ';
    }
}
