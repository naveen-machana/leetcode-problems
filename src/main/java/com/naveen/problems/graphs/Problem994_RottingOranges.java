package com.naveen.problems.graphs;

import java.util.LinkedList;

/*
* https://leetcode.com/problems/rotting-oranges/
* You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
* */
public class Problem994_RottingOranges {
    public static void main(String[] args) {
        int[][] oranges = {{2,1,1},{1,1,0},{0,1,1}};
        Problem994_RottingOranges sol = new Problem994_RottingOranges();
        System.out.println(sol.orangesRotting(oranges));
    }
    private static final int[][] MOVES = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                }

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (size > 0) {
                time++;
                for (int i = 0; i < size; i++) {
                    int[] co = q.poll();
                    int r = co[0], c = co[1];
                    for (int[] move : MOVES) {
                        int x = r + move[0], y = move[1] + c;
                        if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 1) {
                            visited[x][y] = true;
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!visited[i][j] && grid[i][j] == 1)
                    return -1;

        return time == 0 ? 0 : time - 1;
    }
}
