package com.chen.leetcode.hot.topics100;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>无重复字符的最长子串</h1>
 * <p>给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。</p>
 *
 * @author chenbjf
 * @since 2025-04-27 13:59
 */
public class HotTopics0008 {

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
        HotTopics0008 hotTopic0008 = new HotTopics0008();
        System.out.println(hotTopic0008.lengthOfLongestSubstring("abba"));
    }
}
