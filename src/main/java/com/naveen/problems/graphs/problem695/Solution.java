package com.naveen.problems.graphs.problem695;

// https://leetcode.com/problems/max-area-of-island/
// 695. Max Area of Island
// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
// (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
// The area of an island is the number of cells with a value 1 in the island.
//
// Return the maximum area of an island in grid. If there is no island, return 0.
public class Solution {
    int[][] MOVES = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int maxAreaOfIsland(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(board, i, j, m, n, visited, 1));
                }
            }
        }
        return maxArea;
    }

    int dfs(char[][] board, int r, int c, int m, int n, boolean[][] visited, int area) {
        visited[r][c] = true;

        int res = area;
        for (int[] move : MOVES) {
            int nextr = move[0] + r, nextc = move[1] + c;
            if (nextr >= 0 && nextr < m && nextc >= 0 && nextc < n
                    && !visited[nextr][nextc] && board[nextr][nextc] == 1) {
                res = Math.max(res, dfs(board, nextr, nextc, m, n, visited, res + 1));
            }
        }
        return res;
    }
}
