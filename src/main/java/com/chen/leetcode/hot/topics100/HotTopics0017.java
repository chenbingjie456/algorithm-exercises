package com.chen.leetcode.hot.topics100;

/**
 * TODO
 *
 * @author chenbjf
 * @since 2025-06-11 19:51
 */
public class HotTopics0017 {

    public void setZeroes(int[][] matrix) {
        boolean lineZero = false;
        boolean columnZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (!lineZero && matrix[i][0] == 0) {
                lineZero = true;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && !columnZero && matrix[0][j] == 0) {
                    columnZero = true;
                }
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

    }
}
