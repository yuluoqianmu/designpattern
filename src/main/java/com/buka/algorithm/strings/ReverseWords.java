package com.buka.algorithm.strings;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。

 示例:

 输入: "the sky is blue",
 输出: "blue is sky the".
 说明:

 无空格字符构成一个单词。
 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {

    public static String reverseWords(String s) {
        if ("".equals(s.trim()))
            return "";

        String  str = s.trim();

        StringBuffer sb = new StringBuffer();

        String[] strs = str.split(" ");
        for (int i=strs.length-1; i>=0; --i) {
            if ("".equals(strs[i]))
                continue;
            sb.append(strs[i]).append(" ");
        }
        String result = sb.toString();
        result = result.substring(0, result.length()-1);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("   a   b "));
    }
}
