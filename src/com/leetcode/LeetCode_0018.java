package com.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_0018 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);

        int i = 0;
        while(i < nums.length) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < nums.length) {
                int left = j + 1;
                int right = nums.length - 1;
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j] );
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        while (nums[left]== nums[left - 1] && left < right) {
                            left++;
                        }
                        right--;
                        while(nums[right] == nums[right + 1] && left < right) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right --;
                    }
                }
                j++;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_0018 leetCode_0018 = new LeetCode_0018();
        int[] nums = {-5,-4,-2,-2,-2,-1, 0,0,1};
        int target = -9;
        List<List<Integer>> result = leetCode_0018.fourSum(nums, target);
        System.out.println(result);
    }
}
