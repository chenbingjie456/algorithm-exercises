package com.chen.leetcode.hot.topics100;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author chenbjf
 * @since 2025-06-12 09:25
 */
public class HotTopics0019 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int lineEnd = matrix.length;
        int lineStart = 0;
        int columnEnd = matrix[0].length;
        int columnStart = 0;
        List<Integer> result = new ArrayList<>();
        while (lineStart < lineEnd && columnStart < columnEnd) {
            spiral(lineStart, lineEnd, columnStart, columnEnd, result, matrix);
            lineStart++;
            columnStart++;
            columnEnd--;
            lineEnd--;
        }
        return result;
    }


    private void spiral(int lineStart, int lineEnd, int columnStart, int columnEnd, List<Integer> result, int[][] matrix) {
        if (lineStart < lineEnd) {
            for (int i = columnStart; i < columnEnd; i++) {
                result.add(matrix[lineStart][i]);
            }
        }
        lineStart++;
        if (columnStart < columnEnd) {
            for (int i = lineStart; i < lineEnd; i++) {
                result.add(matrix[i][columnEnd - 1]);
            }
        }
        columnEnd--;

        if (lineStart < lineEnd) {
            for (int i = columnEnd - 1; i >= columnStart; i--) {
                result.add(matrix[lineEnd - 1][i]);
            }
        }
        lineEnd--;

        if (columnStart < columnEnd) {
            for (int i = lineEnd - 1; i >= lineStart; i--) {
                result.add(matrix[i][columnStart]);
            }
        }
        columnStart++;
    }

    public static void main(String[] args) {
        HotTopics0019 topics0019 = new HotTopics0019();
        int[][] matrix = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9, 10, 11, 12}};
        topics0019.spiralOrder(matrix);
        System.out.println(123);

    }
}
