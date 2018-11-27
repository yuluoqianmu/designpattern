package com.buka.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shaomaolin on 2018/11/25.
 * 无重复字符的最长子串
 *
 * 示例 1:
 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 示例 2:
 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 示例 3:
 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubString {


    /**
     * 滑动窗口是数组/字符串问题中常用的抽象概念。
     * 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，
     * 即 [i, j)（左闭，右开）。
     * 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。
     * 例如，我们将 [i, j) 向右滑动 1 个元素，
     * 则它将变为 [i+1, j+1)（左闭，右开）。

     回到我们的问题，我们使用 HashSet 将字符存储在当前窗口 [i, j)（最初 j = i）中。
     然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。
     直到 s[j] 已经存在于 HashSet 中。
     此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。
     如果我们对所有的 i 这样做，就可以得到答案。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int i=0,j=0;
        int ret = 0;
        Set<Character> set = new HashSet<>();

        while (i<len && j<len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ret = Math.max(ret, j-i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }

        }


        return ret;
    }



    public int lengthOfLongestSubstring_optimise(String s) {

        int len = s.length();
        int ans = 0;

        Map<Character,Integer> map = new HashMap<>();

        for (int i=0,j=0; j<len; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j+1);

        }
        return ans;
    }


    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

}
