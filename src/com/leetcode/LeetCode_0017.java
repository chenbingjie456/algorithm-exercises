package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0017 {
    static Map<Integer, char[]> map = new HashMap<>();
    static {
        char[] num2 = {'a', 'b', 'c'};
        char[] num3 = {'d', 'e', 'f'};
        char[] num4 = {'g', 'h', 'i'};
        char[] num5 = {'j', 'k', 'l'};
        char[] num6 = {'m', 'n', 'o'};
        char[] num7 = {'p', 'q', 'r', 's'};
        char[] num8 = {'t', 'u', 'v'};
        char[] num9 = {'w', 'x', 'y', 'z'};
        map.put(2, num2);
        map.put(3, num3);
        map.put(4, num4);
        map.put(5, num5);
        map.put(6, num6);
        map.put(7, num7);
        map.put(8, num8);
        map.put(9, num9);
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            char[] charrs = map.get(num);
            List<String> tmp = new ArrayList<>();
            if (result.size() == 0) {
                for (char ch : charrs) {
                    tmp.add(ch + "");
                }
            } else {
                for (char ch : charrs) {
                    for (String str : result) {
                        tmp.add(str + ch);
                    }
                }
            }
            result = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_0017 leetCode_0017 = new LeetCode_0017();
        List<String> str = leetCode_0017.letterCombinations("234");
        System.out.println(str);
    }
}
