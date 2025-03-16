package com.chen.leetcode.firstPage;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 18:36
 */
public class LeetCode0151 {

    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() > 0) {
            String[] sArr = s.split(" ");
            StringBuilder builder = new StringBuilder();
            for (int i = sArr.length - 1; i >=0 ; i --) {
                if (sArr[i].length() > 0) {
                    builder.append(sArr[i]).append(" ");
                }
            }
            return builder.toString().trim();

        }
        return "";
    }
}
