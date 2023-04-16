package com.naveen.problems.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* https://leetcode.com/problems/pacific-atlantic-water-flow/
* There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
* The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and
* bottom edges. The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights
* where heights[r][c] represents the height above sea level of the cell at coordinate (r, c). The island receives a lot
* of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring
* cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean
* into the ocean. Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can
* flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
* */
public class Problem417_PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> atl = new HashSet<>();

        for (int c = 0; c < n; c++) {
            dfs(0, c, m, n, pac, heights, heights[0][c]);
            dfs(m - 1, c, m, n, atl, heights, heights[m - 1][c]);
        }

        for (int r = 0; r < m; r++) {
            dfs(r, 0, m, n, pac, heights, heights[r][0]);
            dfs(r, n - 1, m, n, atl, heights, heights[r][n - 1]);
        }

        pac.retainAll(atl);
        return new ArrayList<>(pac);
    }

    private void dfs(int i, int j, int m, int n, Set<List<Integer>> visit, int[][] heights, int prevHeight) {
        if (i < 0 || i >= m || j < 0 || j >= n
                || visit.contains(List.of(i, j))
                || heights[i][j] < prevHeight) return;

        visit.add(List.of(i, j));

        dfs(i + 1, j, m, n, visit, heights, heights[i][j]);
        dfs(i - 1, j, m, n, visit, heights, heights[i][j]);
        dfs(i, j + 1, m, n, visit, heights, heights[i][j]);
        dfs(i, j - 1, m, n, visit, heights, heights[i][j]);
    }
}
