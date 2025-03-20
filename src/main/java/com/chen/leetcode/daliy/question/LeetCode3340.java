package com.chen.leetcode.daliy.question;

/**
 * <a href = "https://leetcode.cn/problems/check-balanced-string/description/?envType=daily-question&envId=2025-03-14">
 *     3340. 检查平衡字符串
 * </a>
 *
 * @author chenbjf
 * @since 2025-03-14 09:39
 */
public class LeetCode3340 {

    public boolean isBalanced(String num) {
        char[] charArr = num.toCharArray();
        int count = 0;
        for (int i =0; i < charArr.length; i++) {
            int n = charArr[i] - '0';
            if (i % 2 == 0) {
                count+= n;
            } else {
                count -= n;
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
