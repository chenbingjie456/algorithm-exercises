package com.chen.leetcode.hot.topics100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author chenbjf
 * @since 2025-04-22 11:06
 */
public class HotTopics0006 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int needValue = -nums[i];
            while (j < k) {
                int value = nums[j] + nums[k];
                if (value == needValue) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j = moveIndexJ(j, nums);
                    k = moveIndexK(k, nums);
                } else if (value > needValue) {
                    k = moveIndexK(k, nums);
                } else {
                    j = moveIndexJ(j, nums);
                }
            }
        }
        return result;
    }

    private int moveIndexJ(int idx, int[] nums) {
        idx++;
        while (idx < nums.length && nums[idx] == nums[idx-1]) {
            idx++;
        }
        return idx;
    }

    private int moveIndexK(int idx, int[] nums) {
        idx--;
        while (idx >=0 && nums[idx] == nums[idx+1]) {
            idx--;
        }
        return idx;
    }


    public static void main(String[] args) {
        HotTopics0006 hotTopics0006 = new HotTopics0006();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = hotTopics0006.threeSum(nums);
        System.out.println(result);
    }
}
