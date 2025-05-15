package com.chen.leetcode.hot.topics100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>找到字符串中所有字母异位词</h1>
 * <p>给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>
 *
 * @author chenbjf
 * @since 2025-04-27 14:50
 */
public class HotTopics0009 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        int[] chars = new int[128];
        for (char c : p.toCharArray()) chars[c]++;
        int head = 0, tail = 0;
        char[] sc = s.toCharArray();
        while (tail < sc.length) {
            if (chars[sc[tail]] > 0) {
                chars[sc[tail++]]--;
                if ((tail - head) == p.length()){
                    result.add(head);
                }
            } else{
                chars[sc[head++]]++;
            }
        }
        return result;
    }
}
