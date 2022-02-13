package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/12/6 17:45
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 *
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 *
 * 如果可以构成，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                map.put(ch, count + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                if (count == 0) {
                    return false;
                } else {
                    map.put(ch, --count);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_0383 leetCode_0383 = new LeetCode_0383();
        System.out.println(leetCode_0383.canConstruct("aa", "ab"));
    }
}
