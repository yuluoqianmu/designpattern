package com.buka.algorithm.strings;

import java.util.*;

/**
 * Created by shaomaolin on 2018/12/25.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return  new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i=0; i<strs.length; i++) {

            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String sortStr = String.valueOf(ch);
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, new ArrayList<>());
            }
            map.get(sortStr).add(strs[i]);

        }

        return new ArrayList<>(map.values());
    }
}
