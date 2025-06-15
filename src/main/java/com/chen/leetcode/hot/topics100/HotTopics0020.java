package com.chen.leetcode.hot.topics100;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * @author chenbjf
 * @since 2025-06-12 10:58
 */
public class HotTopics0020 {

    public void rotate(int[][] matrix) {
        int lineStart = 0, lineEnd = matrix.length - 1;
        int columnStart = 0, columnEnd = lineEnd;
        while (lineStart < lineEnd && columnStart < columnEnd) {
            rotate(lineStart, lineEnd, columnStart, columnEnd, matrix);
            lineStart++;
            lineEnd--;
            columnStart++;
            columnEnd--;
        }
    }


    private void rotate(int lineStart, int lineEnd, int columnStart, int columnEnd, int[][] matrix) {
        int temp1, temp2;
        int i = 0;
        while (i < (columnEnd - columnStart)) {
            temp1 = matrix[lineStart + i][columnEnd];
            matrix[lineStart + i][columnEnd] =  matrix[lineStart][columnStart + i];

            temp2 = matrix[lineEnd][columnEnd - i];
            matrix[lineEnd][columnEnd - i] = temp1;

            temp1 = matrix[lineEnd - i][columnStart];
            matrix[lineEnd - i][columnStart] = temp2;

            matrix[lineStart][columnStart + i] = temp1;

            i++;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {2, 29, 20, 26, 16, 28},
                {12,27, 9,  25, 13, 21},
                {32,33, 32, 2,  28, 14},
                {13,14, 32, 27, 22, 26},
                {33,1,  20, 7,  21, 7},
                {4, 24, 1,  6,  32, 34}
        };
        HotTopics0020 topics0020 = new HotTopics0020();
        topics0020.rotate(matrix);
        System.out.println(123);


    }
}
