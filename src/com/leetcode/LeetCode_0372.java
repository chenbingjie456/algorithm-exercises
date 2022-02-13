package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/12/6 11:08
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 *
 */
public class LeetCode_0372 {
    public int superPow(int a, int[] b) {
        if (b.length == 1 && b[0] == 0) {
            return 1;
        }
        if (a == 1) {
            return 1;
        } else if (a % 1337 == 0 || a % 1337 == 1) {
            return a % 1337;
        }

        List<Integer> list = new ArrayList<>();
        while (b.length >= 1 && b[0] != 0) {
            if (a > 1337) {
                a = a % 1337;
            }
            int tmp = a;
            int count = 1;
            while (a < 1337)  {
                a = a*tmp;
                count++;
            }
            Map<String, Object> result = divide(b, count);
            int[] value = (int[])result.get("value");
            b=value;
            int mod = (int) result.get("mod");
            if (mod != 0) {
                list.add((int)Math.pow(tmp, mod));
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        int mod = 1;
        for (int i =0; i < list.size(); i++) {
            int value = mod * list.get(i);
            mod = value % 1337;
        }
        return mod;
    }


    private Map<String, Object> divide(int[] b, int count) {
        int i = 0;
        int mod = 0;
        List<Integer> list = new ArrayList<>();
        int length = b.length;
        while (i < length) {
            int divieValue = mod * 10 + b[i];
            mod = divieValue % count;
            if (divieValue >= count) {
                list.add(divieValue/count);
            } else {
                if (!list.isEmpty()) {
                    list.add(0);
                }
            }
            i++;
        }
        if(list.isEmpty()) {
            list.add(0);
        }
        int[] array = new int[list.size()];
        for (int j =0; j < list.size(); j++) {
            array[j] = list.get(j);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("value", array);
        map.put("mod", mod);
        return map;
    }

    public static void main(String[] args) {
        LeetCode_0372 leetCode_0372 = new LeetCode_0372();
        int[] b = {2, 0, 0};
        System.out.println(leetCode_0372.superPow(2147483647, b));
    }


}
