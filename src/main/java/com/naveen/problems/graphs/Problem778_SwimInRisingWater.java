package com.naveen.problems.graphs;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
* https://leetcode.com/problems/swim-in-rising-water/
* You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
* The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another
* 4-directionally adjacent square if and only if the elevation of both squares individually are at most t.
* You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
* Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
*
Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
* */
public class Problem778_SwimInRisingWater {
    private static final int[][] MOVES ={{0,1}, {0,-1}, {1, 0}, {-1, 0}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Set<String> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((one, two) -> one[0] - two[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited.add(0 + "#" + 0);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] == n - 1 && cur[2] == n - 1) return cur[0];
            for (int[] move : MOVES) {
                int x = cur[1] + move[0], y = cur[2] + move[1];
                String adjCor = x + "#" + y;
                if (x < 0 || x >= n || y < 0 || y >= n || visited.contains(adjCor)) continue;
                pq.offer(new int[]{Math.max(grid[x][y], cur[0]), x, y});
                visited.add(adjCor);
            }
        }
        return -1;
     }
}
