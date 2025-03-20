package com.chen.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author chenbjf
 * @since 2025-03-12 09:09
 */
public class DemoTest {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 需要和上一次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int needNum = -nums[i];
            int left = i + 1;
            int right = nums.length -1;

            while (left < right) {
                int tempNum = nums[left] + nums[right];
                if (tempNum == needNum) {
                    Integer[] arr = {nums[i], nums[left], nums[right]};
                    allList.add(Arrays.asList(arr));
                    while (++left < right && nums[left] == nums[left - 1]) {}
                    while (--right > left && nums[right] == nums[right + 1]) {}
                } else if (tempNum > needNum) {
                    while (--right > left && nums[right] == nums[right + 1]) {}
                } else {
                    while (++left < right && nums[left] == nums[left - 1]) {}
                }
            }

        }
        return allList;
    }

    public static void main(String[] args) {
        int[] arr = {};
        List<List<Integer>> res = threeSum(arr);
        System.out.println(res);
    }
}
