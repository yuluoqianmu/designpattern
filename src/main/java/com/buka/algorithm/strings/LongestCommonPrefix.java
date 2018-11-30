package com.buka.algorithm.strings;

/**
 * Created by shaomaolin on 2018/11/25.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";
        for (int j=0; j<strs[0].length(); j++) {
            for (int i=1; i<strs.length; i++) {
                if (j==strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j))
                    return strs[0].substring(0, j);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
