package com.chen.leetcode.firstPage;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/17 23:02
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        char[] tCharArr = t.toCharArray();
        for (int i = 0; i < tCharArr.length; i ++) {
            char ch = tCharArr[i];

            if (sMap.containsKey(ch)) {
                int num = sMap.get(ch) - 1;
                if (num == 0) {
                    sMap.remove(ch);
                } else {
                    sMap.put(ch, num);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
