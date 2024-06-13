package com.chen.leetcode.firstPage;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href = "https://leetcode.cn/problems/roman-to-integer/description/">罗马数字转整数</a>
 *
 * @author chenbjf
 * @since 2024-06-13 16:46
 */
public class LeetCode0013 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] charArray = s.toCharArray();

        if (charArray.length < 2) {
            return map.get(charArray[0]);
        }
        int i=0, j = i+1;
        int value = 0;
        while (i < charArray.length && j < charArray.length) {
            if (map.get(charArray[i]) < map.get(charArray[j]) ) {
                value = value + map.get(charArray[j]) - map.get(charArray[i]);
                i = i+2;
                j = j+2;
            } else {
                value = value + map.get(charArray[i]);
                i++;
                j++;
            }
        }

        if (i < charArray.length) {
            value = value + map.get(charArray[i]);
        }
        return value;
    }
}
