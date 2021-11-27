package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/25 10:41
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0006 {
    public String convert(String s, int numRows) {
        Map<Integer, StringBuffer> map = new HashMap<>();
        if (numRows <= 1) {
            return s;
        }
        if (s==null || s.length() < 1) {
            return null;
        }
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (i % (numRows - 1) == 0) {
                flag = !flag;
            }
            Integer line = 0;
            if (flag) {
                line = i % (numRows - 1) + 1;
            } else {
                line = numRows - (i % (numRows - 1));
            }
            if (map.containsKey(line)) {
                map.put(line, map.get(line).append(s.charAt(i)));
            } else {
                map.put(line, new StringBuffer().append(s.charAt(i)));
            }
        }
        StringBuffer result = new StringBuffer();
        for (Integer j=1; j <= map.keySet().size(); j++){
            result = result.append(map.get(j));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LeetCode_0006 leetCode_0006 = new LeetCode_0006();
        String s = "A";
        System.out.println(leetCode_0006.convert(s, 2));
    }
}
