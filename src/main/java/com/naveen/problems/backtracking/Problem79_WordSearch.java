package com.naveen.problems.backtracking;

import java.util.HashSet;
import java.util.Set;

/*
* https://leetcode.com/problems/word-search/
* Given an m x n grid of characters board and a string word, return true if word exists in the grid.
* The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
* or vertically neighboring. The same letter cell may not be used more than once.
* */
public class Problem79_WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (find(i, j, m, n, board, word, 0, new HashSet<>())) return true;
            }
        }
        return false;
    }

    int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private boolean find(int i, int j, int m, int n, char[][] board, String word, int cindex, Set<String> visited) {
        String key = i + "#" + j;
        if (cindex == word.length()) return true;
        if (i < 0 || j < 0 || i >= m || j >= n
                || visited.contains(key)
                || board[i][j] != word.charAt(cindex)) return false;

        visited.add(key);
        for (int[] move : moves) {
            if (find(i + move[0], j + move[1], m, n, board, word, cindex + 1, visited))
                return true;
        }
        visited.remove(key);
        return false;
    }
}
