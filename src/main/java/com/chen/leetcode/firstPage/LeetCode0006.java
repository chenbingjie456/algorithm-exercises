package com.chen.leetcode.firstPage;

/**
 * <a href="https://leetcode.cn/problems/zigzag-conversion/description/">Z 字形变换</a>
 *
 * @author chenbjf
 * @since 2024-06-11 15:08
 */
public class LeetCode0006 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int everyNums = 2 * numRows - 2;

        int groupNums = s.length() % everyNums == 0? s.length() / everyNums: s.length() / everyNums + 1;

        int[] startIndex = new int[groupNums];
        for (int i = 0; i < groupNums; i++) {
            startIndex[i] = everyNums * i;
        }

        String res = "";
        for (int i = 0; i < numRows; i++) {

            if (i == 0) {
                for (int j = 0; j < startIndex.length; j++) {
                    res += s.charAt(startIndex[j]);
                }
            } else if (i == numRows - 1) {
                for (int j = 0; j < startIndex.length; j++) {
                    if (startIndex[j] + i < s.length()) {
                        res += s.charAt(startIndex[j] + i);
                    }
                }
            } else {
                for (int j = 0; j < startIndex.length; j++) {
                    if (startIndex[j] + i < s.length()) {
                        res += s.charAt(startIndex[j] + i);
                    }
                    if (startIndex[j] + 2 * numRows - 2 - i < s.length()) {
                        res += s.charAt(startIndex[j] + 2 * numRows - 2 - i);
                    }
                }
            }
        }

        return res;

    }


    //方法二

    public String convert2(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        String[] strArr = new String[numRows];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = "";
        }

        char[] charArr = s.toCharArray();
        boolean flag = true;
        for (int i = 0, j = 0 ;i < charArr.length; i++) {
            strArr[j] +=charArr[i];
            if (flag) {
                if (j == numRows - 1) {
                    j--;
                    flag = false;
                } else {
                    j++;
                }
            } else {
                if (j == 0) {
                    j++;
                    flag = true;
                } else {
                    j--;
                }
            }
        }
        String str = "";
        for (int i = 0; i < numRows; i++) {
            str += strArr[i];

        }
        return str;
    }



    public static void main(String[] args) {
        LeetCode0006 code0006 = new LeetCode0006();

        //PAHNAPLSIIGYIR, PINALSIGYAHRPI
        System.out.println(code0006.convert2("PAYPALISHIRING", 3));
    }
}
