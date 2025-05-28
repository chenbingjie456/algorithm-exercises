package com.chen.leetcode.firstPage;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: new java files header..
 *
 * <a href= "https://leetcode.cn/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150">
 *
 *  205. 同构字符串
 *     </a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/17 22:12
 */
public class LeetCode0205 {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Map<Character, Character> sTot = new HashMap<>();
        Map<Character, Character> tTos = new HashMap<>();

        for (int i = 0; i < sArr.length; i++) {
            char chs = sArr[i];
            char cht = tArr[i];
            if (!sTot.containsKey(chs) && !tTos.containsKey(cht)) {
                sTot.put(chs, cht);
                tTos.put(cht, chs);
            } else if (sTot.containsKey(chs)) {
                if (!sTot.get(chs).equals(cht)) {
                    return false;
                }
            } else if (tTos.containsKey(cht)) {
                if (!tTos.get(cht).equals(chs)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode0205.isIsomorphic("ggg", "ddd"));
    }
}
