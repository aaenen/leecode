package com.sword;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String string = "\"We are happy.\"";
        System.out.println(replaceSpace(string));
    }
    //使用一个新的对象，复制 string，复制的过程对其判断，是空格则替换，否则直接复制，类似于数组复制
    private static String replaceSpace(String string) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < string.length(); i++){
            char c = string.charAt(i);
            //append() 在每个 p 元素结尾插入内容：
            if(c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }

}
