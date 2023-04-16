package com.naveen.problems.graphs;

import java.util.Arrays;

// https://leetcode.com/problems/surrounded-regions/
// 130. Surrounded Regions
// Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
public class Problem130_SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int c = 0; c < n; c++) {
            if (!visited[0][c] && board[0][c] == 'O') dfs(0, c, m, n, visited, board);
            if (!visited[m - 1][c] && board[m - 1][c] == 'O') dfs(m - 1, c, m, n, visited, board);
        }

        for (int r = 0; r < m; r++) {
            if (!visited[r][0] && board[r][0] == 'O') dfs(r, 0, m, n, visited, board);
            if (!visited[r][n - 1] && board[r][n - 1] == 'O') dfs(r, n - 1, m, n, visited, board);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!visited[i][j]) board[i][j] = 'X';
    }

    private void dfs(int i, int j, int m, int n, boolean[][] visited, char[][] board) {
        if (i < 0 || j < 0 || i >= m || j >= n
            || visited[i][j]
            || board[i][j] == 'X') return;

        visited[i][j] = true;
        dfs(i + 1, j, m, n, visited, board);
        dfs(i - 1, j, m, n, visited, board);
        dfs(i, j + 1, m, n, visited, board);
        dfs(i, j - 1, m, n, visited, board);
    }
}
