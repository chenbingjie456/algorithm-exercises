package com.chen.leetcode.hot.topics100;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author chenbjf
 * @since 2025-04-21 14:44
 */
public class HotTopics0002 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String sortStr = sortStr(strs[i]);
            if (resMap.containsKey(sortStr)) {
                resMap.get(sortStr).add(strs[i]);
            } else {
                List<String> resList = new ArrayList<>();
                resList.add(strs[i]);
                resMap.put(sortStr, resList);
            }
        }
        List<List<String>> result = new ArrayList<>();
        resMap.keySet().forEach(key -> result.add(resMap.get(key)));
        return result;
    }

    private String sortStr(String item) {
        char[] charArr = item.toCharArray();
        Arrays.sort(charArr);
        return String.copyValueOf(charArr);
    }
    public static void main(String[] args) {
        HotTopics0002 hotTopics0002 = new HotTopics0002();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = hotTopics0002.groupAnagrams(str);
        System.out.println(123);
    }
}
