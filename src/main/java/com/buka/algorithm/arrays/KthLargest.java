package com.buka.algorithm.arrays;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 示例 2:

 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4
 说明:

 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class KthLargest {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();


        for (int value:nums) {
            queue.add(value);
            if (queue.size()>k){
                queue.poll();
            }

        }

        return queue.peek();

    }

    public static int findKthLargest_3(int[] nums, int k){
        if (k>nums.length || k<1)
            throw new RuntimeException("数据异常");

        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i=0; i<k; i++) {
            queue.add(nums[i]);
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }

        return queue.peek();

    }


    public int findKthLargest_2(int[] nums, int k) {

        int begin = 0;
        int end = nums.length - 1;
        k = nums.length + 1 - k;
        while (begin < end) {
            int pos = partition(nums, begin, end);
            if (pos==k-1)
                break;
            else if (pos < k-1)
                begin = pos + 1;
            else
                end = pos - 1;

        }
        return nums[k-1];
    }

    public int partition(int[] nums, int begin, int end) {
        int less = begin - 1;
        int more = end;
        while(begin < more) {
            if (nums[begin] < nums[end]) {
                swap(nums, ++less, begin++);
            } else if (nums[begin] > nums[end]) {
                swap(nums, --more, end);
            } else {
                end++;
            }
        }
        swap(nums, more, end);
        return less+1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        findKthLargest_3(arr, 2);
    }
}
