package com.chen.leetcode.firstPage;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix/">最长公共前缀</a>
 *
 * @author chenbjf
 * @since 2024-06-13 16:52
 */
public class LeetCode0014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String strMax = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String tempStr = strs[i];
            int j = 0;
            while (j < tempStr.length() && j < strMax.length()) {
                if (tempStr.charAt(j) != strMax.charAt(j)) {
                    break;
                }
                j++;
            }
            strMax = tempStr.substring(0, j);
            if (strMax.length() == 0) {
                return strMax;
            }
        }

        return strMax;
    }

    public static void main(String[] args) {
        LeetCode0014 code0014 = new LeetCode0014();
        String[] str = {"aaa","aa","aaa"};
        System.out.println(code0014.longestCommonPrefix(str));
    }

}
