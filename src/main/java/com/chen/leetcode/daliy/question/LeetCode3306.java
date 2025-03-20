package com.chen.leetcode.daliy.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/?envType=daily-question&envId=2025-03-13">
 *     元音辅音字符串计数 II
 * </a>
 *
 * @author chenbjf
 * @since 2025-03-13 10:44
 */
public class LeetCode3306 {

    static Set<Character> charSet = new HashSet<>();
    static {
        charSet.add('a');
        charSet.add('e');
        charSet.add('i');
        charSet.add('o');
        charSet.add('u');
    }

    public long countOfSubstrings(String word, int k) {
        char[] charArr = word.toCharArray();
        return count(charArr, k) - count(charArr, k+1);
    }

    private int count(char[] charArr, int k) {
        int allCount = 0;
        int left = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int fuNum = 0;
        for (int right = 0; right < charArr.length; right++) {
            if (charSet.contains(charArr[right])) {
                if (charMap.containsKey(charArr[right])) {
                    charMap.put(charArr[right], 1 + charMap.get(charArr[right]));
                } else {
                    charMap.put(charArr[right], 1);
                }
            } else {
                fuNum++;
            }

            while (charMap.keySet().size() == 5 && fuNum >= k) {
                if (charSet.contains(charArr[left])) {
                    int num = charMap.get(charArr[left]) -1;
                    if (num == 0) {
                        charMap.remove(charArr[left]);
                    } else {
                        charMap.put(charArr[left], num);
                    }
                } else {
                    fuNum--;
                }
                left++;
            }
            allCount+=left;
        }
        return allCount;
    }


    public static void main(String[] args) {
        LeetCode3306 code3306 = new LeetCode3306();
        System.out.println(code3306.countOfSubstrings("ieaouqqieaouqq", 1));
    }

}
