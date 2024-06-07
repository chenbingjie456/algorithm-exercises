package com.chen.leetcode.firstPage;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">3. 无重复字符的最长子串</a>
 *
 *
 * @author chenbjf
 * @since 2024-06-07 11:12
 */
public class LeetCode0003 {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right;
        char[] strArr = s.toCharArray();
        int maxLength = 0;
        for (right = 0; right < strArr.length; right++) {
            if (map.containsKey(strArr[right])) {
                if (right - left > maxLength) {
                    maxLength = right - left;
                }
                int pos = map.get(strArr[right]);
                if (pos >= left) {
                    left = pos + 1;
                }
            }
            map.put(strArr[right], right);
        }
        if (right - left > maxLength) {
            maxLength = right -left;
        }
        return maxLength;
    }


    public static void main(String[] args) {
        LeetCode0003 leetCode0003 = new LeetCode0003();
        System.out.println(leetCode0003.lengthOfLongestSubstring("pwwkew"));
    }
}
