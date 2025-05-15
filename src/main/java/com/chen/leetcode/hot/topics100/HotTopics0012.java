package com.chen.leetcode.hot.topics100;

/**
 * 76. 最小覆盖子串
 *
 * @author chenbjf
 * @since 2025-05-12 10:35
 */
public class HotTopics0012 {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] charT = new int[128];
        int[] charS = new int[128];
        for (char c : t.toCharArray()) {
            charT[c] ++;
        }
        char[] sArr = s.toCharArray();
        int countChars = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        String result = "";
        for (int right = 0; right < sArr.length; right++) {
            charS[sArr[right]]++;
            if (charS[sArr[right]] <= charT[sArr[right]]) {
                countChars++;
            }
            while (left <= right && charS[sArr[left]] > charT[sArr[left]]) {
                charS[sArr[left]]--;
                left++;
            }
            if (countChars == t.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        HotTopics0012 hotTopics0012 = new HotTopics0012();

        System.out.println(hotTopics0012.minWindow("ABCDDDERPSD", "BER"));
    }
}
