package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0030 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i ++) {
            if (map.containsKey(words[i])) {
                Integer count = map.get(words[i]);
                map.put(words[i], count + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        int oneLength = words[0].length();
        int allLength = oneLength * words.length;

        for (int i = 0; i < s.length() - allLength + 1; i++) {
            int j = i;
            Map<String, Integer> tmpMap = new HashMap<>();
            while (j + oneLength <= i + allLength) {
                String str = s.substring(j, j + oneLength);
                if (map.containsKey(str)) {
                    if (!tmpMap.containsKey(str)) {
                       tmpMap.put(str, 1);
                    } else {
                        int count = tmpMap.get(str);
                        int realCount = map.get(str);
                        if (realCount == count) {
                            break;
                        } else {
                            tmpMap.put(str, count + 1);
                        }
                    }
                } else {
                    break;
                }
                j = j + oneLength;
            }
            if (j == i+ allLength) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_0030 leetCode_0030 = new LeetCode_0030();
        String str = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        System.out.println(leetCode_0030.findSubstring(str, words));
    }
}
