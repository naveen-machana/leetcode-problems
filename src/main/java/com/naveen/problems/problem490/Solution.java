package com.naveen.problems.problem490;

// https://leetcode.ca/all/490.html
public class Solution {
    private int[][] moves = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

    boolean hasPath(int[][] g, int[] start, int[] dst) {
        boolean[][] visited = new boolean[g.length][g[0].length];

        return dfs(g, visited, start[0], start[1], dst);
    }

    boolean dfs(int[][] g, boolean[][] visited, int i, int j, int[] dst) {
        if (i == dst[0] && j == dst[1]) return true;

        if (visited[i][j]) return false;
        visited[i][j] = true;

        for (int[] move : moves) {
            int x = i, y = j;
            while (x >= 0 && x < g.length && y >= 0 && y < g[0].length && g[x][y] != 1) {
                x = x + move[0]; y = y + move[1];
            }
            x = x - move[0]; y = y - move[1];
            if (!visited[x][y] && dfs(g, visited, x, y, dst))
                return true;
        }
        return false;
    }
}
