package com.leetcode.problems100;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/24 17:07
 */

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LeetCode_0005 {
    public String longestPalindrome(String s) {
        int startIndex = 0;
        int endIndex = 0;
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++) {
            int left = 0;
            int right = i;
            while (right < s.length()) {
                if (isHuiWen(left, right, s)) {
                    if ((right - left + 1) > maxLength) {
                        maxLength = right-left+1;
                        startIndex = left;
                        endIndex = right;
                        break;
                    }
                } else {
                    left++;
                    right++;
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    private boolean isHuiWen(int left, int right, String s) {

        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_0005 leetCode_0005 = new LeetCode_0005();
        String s = "aaaa";
        System.out.println(leetCode_0005.longestPalindrome(s));
    }
}
