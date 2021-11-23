package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/23 17:26
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeetCode_0003 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int maxLength = 0;
        int left=0, right = 0;

        while (right < s.length()) {
            if (!isContainAll(left, right, s)) {
                int len = right - left + 1;
                if (len > maxLength) {
                    maxLength = len;
                }
                right ++;
            } else {
                left = left+1;
                right = right+1;
            }
        }
        return maxLength;
    }

    private boolean isContainAll(int start, int end, String s) {
        Set<Character> set = new HashSet<>();
        while(start <= end) {
            if (set.contains(s.charAt(start))) {
                return true;
            } else {
                set.add(s.charAt(start));
            }
            start ++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        LeetCode_0003 leetCode0003 = new LeetCode_0003();
        int length = leetCode0003.lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
