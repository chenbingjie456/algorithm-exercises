package com.chen.leetcode.firstPage;

/**
 * <a href="https://leetcode.cn/problems/palindrome-number/">9. 回文数</a>
 *
 * @author chenbjf
 * @since 2024-06-13 13:46
 */
public class LeetCode0009 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = Integer.toString(x);
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0009 code0009 = new LeetCode0009();
        System.out.println(code0009.isPalindrome(12321));
    }
}
