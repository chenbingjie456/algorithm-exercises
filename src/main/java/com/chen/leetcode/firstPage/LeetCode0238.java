package com.chen.leetcode.firstPage;

/**
 * <a href= "https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150">
 *
 *     238. 除自身以外数组的乘积</a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 17:46
 */
public class LeetCode0238 {

    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int count = 1; ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
             count = count * nums[i - 1];
             ans[i] = count;
        }

        int countAfter = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            ans[i] = ans[i] * countAfter;
            countAfter = countAfter * nums[i];
        }
        ans[0] = countAfter;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3 , 4};
        int[] res = LeetCode0238.productExceptSelf(arr);
        System.out.println(34);
    }
}
