package com.chen.leetcode.firstPage;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: new java files header..
 *
 * <a href = "https://leetcode.cn/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150">202. 快乐数</a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/17 23:38
 */
public class LeetCode0202 {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            int num = calNum(n);
            if (num == 1) {
                return true;
            } else {
                set.add(n);
                n = num;
            }
        }
        return false;
    }

    private static int calNum(int value) {
        int count = 0;
        while (value != 0) {
            int num = value % 10;
            count += num * num;
            value = value/10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode0202.isHappy(19));
    }
}
