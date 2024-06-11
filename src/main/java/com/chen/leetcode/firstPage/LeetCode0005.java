package com.chen.leetcode.firstPage;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/">最长回文子串</a>
 *
 * @author chenbjf
 * @since 2024-06-11 14:19
 */
public class LeetCode0005 {

    public String longestPalindrome(String s) {


        char[] charArr = s.toCharArray();

        int[] max = {0, 0};
        for (int i = 0; i < charArr.length; i ++) {
            int[] arr = getMaxLength(i, charArr);
            if (arr[1] > max[1]) {
                max = arr;
            }
        }
        return s.substring(max[0], max[0] + max[1]);
    }

    public int[] getMaxLength(int index, char[] arr) {
        int left = index, right = index;
        while (left >= 0) {
            if (arr[left] == arr[index]) {
                left--;
            } else {
                break;
            }
        }
        while (right < arr.length) {
            if (arr[right] == arr[index]) {
                right++;
            } else {
                break;
            }
        }
        while (left >=0 && right < arr.length) {
            if (arr[left] != arr[right]) {
                break;
            } else {
                left--;
                right++;
            }
        }
        int length =  right - left - 1;
        int[] res = {left + 1, length};
        return res;
    }


    public static void main(String[] args) {
        LeetCode0005 code005 = new LeetCode0005();

        String str = "baaab";
        String max = code005.longestPalindrome(str);
        System.out.println(max);
    }
}
