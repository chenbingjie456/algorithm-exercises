package com.chen.leetcode.firstPage;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href = "https://leetcode.cn/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150">383. 赎金信</a>
 *
 * @author chenbjf
 * @since 2025-03-17 10:34
 */
public class LeetCode0383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i< ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (magazineMap.containsKey(ch)) {
                int num = magazineMap.get(ch) - 1;
                if (num == 0) {
                    magazineMap.remove(ch);
                } else {
                    magazineMap.put(ch, num);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
