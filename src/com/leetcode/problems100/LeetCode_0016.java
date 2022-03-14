package com.leetcode.problems100;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0016 {

    public int threeSumClosest(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int minValue = i;
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[j] < nums[minValue]) {
                    minValue = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minValue];
            nums[minValue] = tmp;
        }

        int i = 0;
        int minsum = 0;
        int minDec =  Integer.MAX_VALUE;
        while (i < nums.length -2) {
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int mcha = Math.abs(target -sum);
                if (mcha < minDec) {
                    minDec = mcha;
                    minsum = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
            i++;
        }
        return minsum;
    }

    public static void main(String[] args) {
        LeetCode_0016 leetCode_0016 = new LeetCode_0016();
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(leetCode_0016.threeSumClosest(nums, target));
    }
}
