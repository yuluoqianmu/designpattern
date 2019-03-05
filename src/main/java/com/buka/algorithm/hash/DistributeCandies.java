package com.buka.algorithm.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shaomaolin on 2019/1/23.
 */
public class DistributeCandies {


    public int distributeCandies(int[] candies) {

        Set<Integer> set = new HashSet<>();

        int count = candies.length / 2;

        for (int i=0; i<candies.length; i++) {
            set.add(candies[i]);
        }

        if (set.size() >= count)
            return count;
        return set.size();
    }

}
