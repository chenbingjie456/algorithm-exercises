package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/23 14:05
 */

import java.util.*;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0001 {


    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <=0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i =0; i < nums.length; i++) {
            int needValue = target - nums[i];
            if (map.containsKey(needValue)) {
                result[0] = i;
                result[1] = map.get(needValue);
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LeetCode_0001 leetCode_0001 = new LeetCode_0001();
        int[] nums = {2, 7, 11, 15};
        int [] result = leetCode_0001.twoSum(nums, 17);
        if (result != null) {
            System.out.println(result[0] + "   " + result[1]);
        }
    }
}
