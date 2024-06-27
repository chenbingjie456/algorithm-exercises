package com.chen.leetcode.firstPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/description/">三数之和</a>
 *
 * @author chenbjf
 * @since 2024-06-13 17:36
 */
public class LeetCode0015 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        int needValue, left, right;
        for (int index = 0; index < nums.length; index++) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            needValue = -nums[index];
            left = index+1; right = nums.length - 1;
            while (left < right) {
                int value = nums[left] + nums[right];
                if (value == needValue) {
                    resultList.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    left ++; right--;
                    while (left < right) {
                        if (nums[left] != nums[left-1]){
                            break;
                        }
                        left++;
                    }

                    while (left < right) {
                        if (nums[right] != nums[right + 1]){
                            break;
                        }
                        right--;
                    }
                } else if (value > needValue) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        LeetCode0015 code0015 = new LeetCode0015();
        int[] nums = {-1, -1 ,0, 0,1, 1,2, 2,-1,-4};
        List<List<Integer>> resultList = code0015.threeSum(nums);
        System.out.println(123);
    }



}
