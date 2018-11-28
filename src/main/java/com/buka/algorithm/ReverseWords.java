package com.buka.algorithm;

/**
 * Created by shaomaolin on 2018/11/28.
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
