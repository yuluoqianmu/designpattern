package com.buka.algorithm;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 示例1:
 输入: s1 = "ab" s2 = "eidbaooo"
 输出: True
 解释: s2 包含 s1 的排列之一 ("ba").
 示例2:
 输入: s1= "ab" s2 = "eidboaoo"
 输出: False
 注意：
 输入的字符串只包含小写字母
 两个字符串的长度都在 [1, 10,000] 之间
 阶梯思路：滑动窗口
 */
public class CheckInclusion {

    public static boolean checkInclusion(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(char c : s1.toCharArray())
            c1[c-'a']++;

        for(int i=0; i<l2; i++) {
            if(i>=l1)
                --c2[s2.charAt(i-l1)-'a'];
            c2[s2.charAt(i)-'a']++;
            if(Arrays.equals(c1, c2))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
