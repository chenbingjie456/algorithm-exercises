package com.chen.leetcode.firstPage;

import java.util.*;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/17 23:10
 */
public class LeetCode0049 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length <= 1) {
            result.add(Arrays.asList(strs));
            return result;
        }

        Map<String, List<String>> resMap = new HashMap<>();
        for (int i = 0; i < strs.length; i ++) {
            String tempStr = sortString(strs[i]);
            if (resMap.containsKey(tempStr)) {
                List<String> tmpRes = resMap.get(tempStr);
                tmpRes.add(strs[i]);
                resMap.put(tempStr, tmpRes);
            } else {
                List<String> tmpRes = new ArrayList<>();
                tmpRes.add(strs[i]);
                resMap.put(tempStr, tmpRes);
            }
        }

        resMap.keySet().forEach(key -> result.add(resMap.get(key)));
        return result;

    }

    public static String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = LeetCode0049.groupAnagrams(strs);
        System.out.println(123);
    }
}
