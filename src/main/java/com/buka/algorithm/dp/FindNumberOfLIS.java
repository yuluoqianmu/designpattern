 package com.buka.algorithm.dp;

import java.util.Arrays;

/**
 * Created by shaomaolin on 2018/12/25.
 */
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {

        int maxlen = 0, res = 0;
        //以muns[i]结尾的递增序列的长度
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];

        Arrays.fill(dp,0, dp.length, 1);
        Arrays.fill(cnt, 0, cnt.length, 1);

        /**
         * 然后我们遍历数组，对于每个遍历到的数字nums[i]，我们再遍历其之前的所有数字nums[j]，
         * 当nums[i]小于等于nums[j]时，不做任何处理，因为不是递增序列
         */
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                } else if (nums[j] < nums[i] && dp[j] + 1 == dp[i]){
                    cnt[i] += cnt[j];
                }
            }

            maxlen = Math.max(dp[i], maxlen);

        }
        for (int i=0; i<nums.length; i++)
            if (dp[i] == maxlen)
                res += cnt[i];

        return res;

    }
}
