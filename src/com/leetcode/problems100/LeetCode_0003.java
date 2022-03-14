package com.leetcode.problems100;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/23 17:26
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeetCode_0003 {

    //方法一
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


    //方法二
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int startIndex = 0;
        int currentLength = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!map.containsKey(ch) || map.get(ch) < startIndex) {
                map.put(ch, i);
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                startIndex = map.get(ch) + 1;
                map.put(ch, i);
                currentLength = i - startIndex + 1;
            }
        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LeetCode_0003 leetCode0003 = new LeetCode_0003();
        int length = leetCode0003.lengthOfLongestSubstring2(s);
        System.out.println(length);
    }
}
