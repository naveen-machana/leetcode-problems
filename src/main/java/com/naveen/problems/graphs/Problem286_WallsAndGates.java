package com.naveen.problems.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;

/*
https://leetcode.ca/all/286.html
You are given a m x n 2D a initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the
distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
* */
public class Problem286_WallsAndGates {
    private static final int[][] MOVES = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int[][] wallsAndGates(int[][] a, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((one, two) -> one[2] - two[2]);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (visited[r][c]) continue;

            visited[r][c] = true;
            for (int[] move : MOVES) {
                int x = move[0] + r, y = move[1] + c;
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && a[x][y] != -1) {
                    a[x][y] = Math.min(cur[2] + 1, a[x][y]);
                    q.add(new int[]{x, y, a[x][y]});
                }
            }
        }
        return a;
    }
}
