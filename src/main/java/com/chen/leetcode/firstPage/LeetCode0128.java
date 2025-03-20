package com.chen.leetcode.firstPage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <a href= "https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150">128. 最长连续序列</a>
 *
 * @author chenbjf
 * @since 2025-03-18 10:21
 */
public class LeetCode0128 {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set1.add(nums[i]);
        }
        Set<Integer> set2 = new HashSet<>(set1);

        Iterator<Integer> iterator = set1.iterator();
        int allCount = 0;
        while (iterator.hasNext()) {
            int num = iterator.next();
            int count = 1;
            int t = num + 1;
            while (set2.contains(t)) {
                count++;
                set2.remove(t);
                t = t+1;
            }
            int s = num - 1;
            while (set2.contains(s)) {
                count++;
                set2.remove(t);
                s = s - 1;
            }
            if (count > allCount) {
                allCount = count;
            }
        }
        return allCount;

    }


    public static int longestConsecutive2(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            numsSet.add(nums[i]);
        }

        int maxLength = 0;
        for (Integer num : nums) {
            //这里是找到序列开始时的数字
            if (!numsSet.contains(num - 1)) {
                int length = 1;
                int start = num;
                while (numsSet.contains(start + 1)) {
                    length++;
                    start++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(LeetCode0128.longestConsecutive2(nums));

    }
}
