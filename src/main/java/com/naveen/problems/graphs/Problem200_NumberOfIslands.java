package com.naveen.problems.graphs;

// https://leetcode.com/problems/number-of-islands/
// 200. Number of Islands
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
// return the number of islands.
//
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
class Problem200_NumberOfIslands {
    int[][] MOVES = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int numIslands(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!visited[i][j]
                && board[i][j] == '1') {
                    count++;
                    dfs(board, visited, i, j, m, n);
                }
        return count;
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, int m, int n) {
        visited[i][j] = true;

        for (int[] adj : MOVES) {
            int x = i + adj[0], y = j + adj[1];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == '1' && !visited[x][y])
                dfs(board, visited, x, y, m, n);
        }
    }
}
