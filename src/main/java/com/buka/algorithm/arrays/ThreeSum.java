package com.buka.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums == null || nums.length <= 2)
            throw new RuntimeException("数组无效");

        Arrays.sort(nums);

        for (int i=0; i<nums.length-2; ) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[j] + nums[k] == -nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);

                    k--;
                    j++;

                    while (j<k && nums[j] == nums[j-1])
                        j++;
                    while (j<k && nums[k] == nums[k+1])
                        k--;
                } else if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                    while (j<k && nums[k] == nums[k+1])
                        k--;
                } else {
                    j++;
                    while (j<k && nums[j] == nums[j-1])
                        j++;
                }

            }

            // 指向下一个要处理的数
            i++;
            // 从左向右找第一个与之前处理的数不同的数的下标
            while (i < nums.length - 2 && nums[i] == nums[i - 1])
                i++;


        }


        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }


}
