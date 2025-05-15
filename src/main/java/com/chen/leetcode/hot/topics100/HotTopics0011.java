package com.chen.leetcode.hot.topics100;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 *
 * @author chenbjf
 * @since 2025-04-29 10:57
 */
public class HotTopics0011 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int right = 0; right < nums.length; right++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
                queue.removeLast();
            }
            queue.offer(right);

            int left = right - k + 1;
            if (left >= 0) {
                result[left] = nums[queue.peekFirst()];
                if (left == queue.peekFirst()) {
                    queue.removeFirst();
                }
            }
        }
        return result;

    }


    /**
     * 超时
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        int[] resArr = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        int i = 0;
        for (;i < nums.length - k; i++) {
            resArr[i] = queue.peek();
            int next = i + k;
            queue.remove(nums[i]);
            queue.add(nums[next]);
        }
        resArr[i] = queue.peek();
        return resArr;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        HotTopics0011 hotTopics0011 = new HotTopics0011();
        int[] arr = hotTopics0011.maxSlidingWindow(nums, k);
        System.out.println(arr);

    }

}
