package com.naveen.problems.graphs;

// https://leetcode.com/problems/max-area-of-island/
// 695. Max Area of Island
// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
// (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
// The area of an island is the number of cells with a value 1 in the island.
//
// Return the maximum area of an island in grid. If there is no island, return 0.
public class Problem695_MaxAreaOfIsland {
    int[][] MOVES = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int maxAreaOfIsland(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(board, i, j, m, n, visited));
                }
            }
        }
        return maxArea;
    }

    int dfs(int[][] board, int r, int c, int m, int n, boolean[][] visited) {
        visited[r][c] = true;

        int count = 1;
        for (int[] move : MOVES) {
            int x = r + move[0], y = c + move[1];
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && board[x][y] == 1)
                count += dfs(board, x, y, m, n, visited);
        }
        return count;
    }
}
