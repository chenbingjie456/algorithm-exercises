package com.chen.leetcode.firstPage;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 18:41
 */
public class LeetCode0125 {

    public boolean isPalindrome(String s) {
        int left = 0; int right = s.length() - 1;
        s = s.toLowerCase();
        char[] charArr = s.toCharArray();

        while (left < right) {
            if (!isSucc(charArr[left])) {
                left ++;
                continue;
            }
            if (!isSucc(charArr[right])) {
                right --;
                continue;
            }
            if (charArr[left] != charArr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isSucc(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >='a' && c <= 'z') {
            return true;
        }
        return false;
    }
}
