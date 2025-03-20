package com.chen.leetcode.firstPage;

/**
 * <a href="https://leetcode.cn/problems/next-permutation/description/">31. 下一个排列</a>
 *
 * @author chenbjf
 * @since 2024-11-07 13:55
 */
public class LeetCode0031 {

    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i+1]) {
                int t = nums.length - 1;
                while (t >= i+1 && nums[t] <= nums[i]) {
                    t--;
                }
                int temp = nums[t];
                nums[t] = nums[i];
                nums[i]= temp;

                while (t > i + 1 && nums[t] > nums[t-1]) {
                    int temp1 = nums[t];
                    nums[t] = nums[t-1];
                    nums[t-1]= temp1;
                    t--;
                }
                break;
            }
            i--;
        }

        int right = i + 1;
        int left = nums.length -1;
        while (right < left) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left--; right++;
        }
    }


    public static void main(String[] args) {
        LeetCode0031 leetCode0031 = new LeetCode0031();
        int[] nums = {1,5,1};
        leetCode0031.nextPermutation(nums);

        System.out.println(123);
    }
}








