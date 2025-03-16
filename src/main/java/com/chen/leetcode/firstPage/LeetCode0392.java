package com.chen.leetcode.firstPage;

/**
 * <a href = "https://leetcode.cn/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150">392. 判断子序列</a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 21:19
 */
public class LeetCode0392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int sIdx = 0;
        for (int i = 0; i < t.length() && sIdx < sArr.length; i++) {
            if (tArr[i] == sArr[sIdx]) {
                sIdx++;
            }
        }
        return sIdx == sArr.length;
    }
}
