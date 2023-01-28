package com.naveen.problems.problem547;

// https://leetcode.com/problems/number-of-provinces/
public class Solution {
    public int findCircleNum(int[][] g) {
        int m = g.length, n = g[0].length;
        boolean[] visited = new boolean[m];

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (!visited[i]){
                count++;
                dfs(g, visited, i, n);
            }
        }
        return count;
    }

    private void dfs(int[][] g, boolean[] visited, int i, int n) {
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (g[i][j] == 1 && !visited[j])
                dfs(g, visited, j, n);
        }
    }
}
