package com.leetcode.problems100;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/25 19:43
 */

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LeetCode_0014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return null;
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int length = 0;
        boolean flag = false;
        while(true) {
            int i = 0; int j=i+1;
            while (j < strs.length) {
                try {
                    if (strs[i].charAt(length) != strs[j].charAt(length)) {
                        flag = true;
                        break;
                    }
                } catch (Exception e) {
                    flag = true;
                    break;
                }
                i++;
                j++;
            }
            if(flag) {
                break;
            }
            length++;

        }
        return strs[0].substring(0, length);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flower","flower"};
        LeetCode_0014 leetCode_0014 = new LeetCode_0014();
        System.out.println(leetCode_0014.longestCommonPrefix(strs));
    }
}
