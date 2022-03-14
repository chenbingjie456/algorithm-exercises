package com.leetcode.problems100;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/12/7 10:31
 */

import java.util.*;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0037 {

    public void solveSudoku(char[][] board) {

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> grids = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Set<Character> row, column, grid;
                if (rows.containsKey(i)) {
                    row = rows.get(i);
                } else {
                    row = new HashSet<>();
                }
                if (columns.containsKey(j)) {
                    column = columns.get(j);
                } else {
                    column = new HashSet<>();
                }
                int index = i/3 * 10 + j/3;
                if (grids.containsKey(index)) {
                    grid = grids.get(index);
                } else {
                    grid = new HashSet<>();
                }
                if (board[i][j] != '.') {
                    row.add(board[i][j]);
                    column.add(board[i][j]);
                    grid.add(board[i][j]);
                }
                rows.put(i, row);
                columns.put(j, column);
                grids.put(index, grid);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int index = i/3 * 10 + j/3;
                    Set<Character> row = rows.get(i);
                    Set<Character> column = columns.get(j);
                    Set<Character> grid = grids.get(index);
                    char ch = ' ';
                    for (int k = 1; k <= 9; k++) {
                        char tmpch = (char)(k + '0');
                        if(!row.contains(tmpch) && !column.contains(tmpch) && !grid.contains(tmpch)) {
                            ch = tmpch;
                            break;
                        }
                    }
                    board[i][j] = ch;
                    row.add(ch);
                    column.add(ch);
                    grid.add(ch);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        LeetCode_0037 leetCode_0037 = new LeetCode_0037();
        leetCode_0037.solveSudoku(board);
        for (int i =0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }


    }
}
