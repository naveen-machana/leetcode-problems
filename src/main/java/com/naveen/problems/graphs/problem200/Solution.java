package com.naveen.problems.graphs.problem200;

// https://leetcode.com/problems/number-of-islands/
// 200. Number of Islands
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
// return the number of islands.
//
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
class Solution {
    int[][] MOVES = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int numIslands(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(board, i, j, m, n, visited);
                }
            }
        }
        return count;
    }

    void dfs(int[][] board, int r, int c, int m, int n, boolean[][] visited) {
        visited[r][c] = true;

        for (int[] move : MOVES) {
            int nextr = move[0] + r, nextc = move[1] + c;
            if (nextr >= 0 && nextr < m && nextc >= 0 && nextc < n
                    && !visited[nextr][nextc] && board[nextr][nextc] == '1') {
                dfs(board, nextr, nextc, m, n, visited);
            }
        }
    }
}
