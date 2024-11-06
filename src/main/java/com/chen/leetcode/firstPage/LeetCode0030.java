package com.chen.leetcode.firstPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/substring-with-concatenation-of-all-words/description/">30. 串联所有单词的子串</a>
 *
 * @author chenbjf
 * @since 2024-11-05 19:31
 */
public class LeetCode0030 {

    Map<String, Integer> mapValue = new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {
        for (String word : words) {
            if (mapValue.containsKey(word)) {
                mapValue.put(word, mapValue.get(word) + 1);
            } else {
                mapValue.put(word, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        int allLength = words.length * words[0].length();
        if (s.length() < allLength) {
            return result;
        }
        for (int i = allLength; i <= s.length(); i++) {
            if (isContainStr(s.substring(i-allLength, i), words[0].length(), new HashMap<>(mapValue))) {
                result.add(i-allLength);
            }
        }

        return result;
    }

    private boolean isContainStr(String s, int everyLength, Map<String, Integer> mapValue) {
        for (int i = everyLength; i <= s.length(); i+= everyLength) {
            String subStr = s.substring(i - everyLength, i);
            Integer value = mapValue.get(subStr);
            if (value != null && value > 0) {
                mapValue.put(subStr, --value);
            } else {
                return false;
            }
        }
        for (Map.Entry<String, Integer> entry : mapValue.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }



    public List<Integer> findSubstring2(String s, String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        int oneLength = words[0].length();
        for (int i = 0; i < oneLength; i++) {
            List<String> arr = new ArrayList<>();
            for (int idx = i + oneLength; idx <= s.length(); idx += oneLength) {
                arr.add(s.substring(idx - oneLength, idx));
            }
            Map<String, Integer> temp = new HashMap<>();
            int left = 0; int right = 0;
            while (right < arr.size()) {
                String word = arr.get(right);
                if (!wordsMap.containsKey(word)) {
                    right ++;
                    left=right;
                    temp.clear();
                    continue;
                }
                temp.put(word, temp.getOrDefault(word, 0) + 1);
                if (right - left + 1 == words.length) {
                    if (temp.equals(wordsMap)) {
                        result.add(left * oneLength + i);
                    }
                    String leftWord = arr.get(left);
                    if (temp.get(leftWord) == 1) {
                        temp.remove(leftWord);
                    } else {
                        temp.put(leftWord, temp.get(leftWord) - 1);
                    }
                    left++;
                    right++;
                } else {
                    right++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        LeetCode0030 leetCode0030 = new LeetCode0030();
        String[] words = new String[]{
                "foo","bar"
        };
        String s = "barfoothefoobarman";
        List<Integer> list = leetCode0030.findSubstring2(s, words);
        System.out.println(list);
    }
}
