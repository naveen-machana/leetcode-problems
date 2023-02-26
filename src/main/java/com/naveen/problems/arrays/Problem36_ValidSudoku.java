package com.naveen.problems.arrays;

import java.util.HashSet;
import java.util.Set;

public class Problem36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!seen.add(board[i][j] + " in row " + i) ||
                        !seen.add(board[i][j] + " in col " + j) ||
                        !seen.add(board[i][j] + " in block " + ((i / 3) * 3 + j / 3)))
                        return false;
                }
            }
        }
        return true;
    }
}
