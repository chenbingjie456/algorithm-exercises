package com.chen.leetcode.firstPage;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/reverse-integer/description/">7. 整数反转</a>
 *
 * @author chenbjf
 * @since 2024-06-11 16:16
 */
public class LeetCode0007 {

    int[] nums1 = {2,1, 4,7, 4, 8, 3, 6, 4, 7};
    int[] nums2 = {2,1, 4,7, 4, 8, 3, 6, 4, 8};

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();

        boolean isNegative = true;
        if (x > 0) {
            while (x > 0) {
                list.add(x%10);
                x = x/10;
            }
            isNegative = false;
        } else {
            while (x < 0) {
                list.add(x%10);
                x = x/10;
            }
        }



        if (list.size() == 10) {
            int[] nums = nums1;
            if (isNegative) {
                nums = nums2;
            }

            for (int i = 0; i < 10; i++) {
                if (Math.abs(list.get(i)) > nums[i]) {
                    return 0;
                } else if (Math.abs(list.get(i)) < nums[i]) {
                    break;
                }
            }
        }

        int result = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            result+= list.get(i) * Math.pow(10, (list.size() - 1 - i)) ;
        }


        return result;
    }

    public static void main(String[] args) {
        LeetCode0007 code0007 = new LeetCode0007();
        System.out.println(code0007.reverse(1111111113));
    }
}
