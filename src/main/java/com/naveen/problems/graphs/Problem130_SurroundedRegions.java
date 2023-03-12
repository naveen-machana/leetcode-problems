package com.naveen.problems.graphs;

import java.util.Arrays;

// https://leetcode.com/problems/surrounded-regions/
// 130. Surrounded Regions
// Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
public class Problem130_SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X','O','X'},{'X','O','X'},{'X','O','X'}};
        Problem130_SurroundedRegions s = new Problem130_SurroundedRegions();
        s.solve(board);

        System.out.println(Arrays.toString(board));
    }
    int[][] MOVES = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j] && (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
                    dfs(board, i, j, m, n, visited);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    void dfs(char[][] board, int r, int c, int m, int n, boolean[][] visited) {
        visited[r][c] = true;

        for (int[] move : MOVES) {
            int nextr = move[0] + r, nextc = move[1] + c;
            if (nextr >= 0 && nextr < m && nextc >= 0 && nextc < n
                    && !visited[nextr][nextc] && board[nextr][nextc] == 'O') {
                dfs(board, nextr, nextc, m, n, visited);
            }
        }
    }
}
