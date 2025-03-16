package com.chen.leetcode.firstPage;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 18:33
 */
public class LeetCode0058 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() > 0) {
            String[] sArr = s.split(" ");
            return sArr[sArr.length - 1].length();
        }
        return 0;
    }
}
