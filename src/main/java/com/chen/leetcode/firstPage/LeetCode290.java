package com.chen.leetcode.firstPage;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: new java files header..
 *
 * <a href= "https://leetcode.cn/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150">290. 单词规律</a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/17 22:30
 */
public class LeetCode290 {

    public static boolean wordPattern(String pattern, String s) {
        String[] strArr = s.split(" ");
        char[] patternArr = pattern.toCharArray();

        if (strArr.length != patternArr.length) {
            return false;
        }

        Map<Character, String> charToString = new HashMap<>();

        Map<String, Character> stringToChar = new HashMap<>();

        for (int i = 0; i < patternArr.length; i++) {
            char ch = patternArr[i];
            String tempStr = strArr[i];

            if (!charToString.containsKey(ch) && !stringToChar.containsKey(tempStr)) {
                charToString.put(ch, tempStr);
                stringToChar.put(tempStr, ch);
            } else if (charToString.containsKey(ch)) {
                if (!charToString.get(ch).equals(tempStr)) {
                    return false;
                }
            } else if (stringToChar.containsKey(tempStr)) {
                if (stringToChar.get(tempStr) != ch) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(LeetCode290.wordPattern("abba", "dog dog dog dog"));
    }
}
