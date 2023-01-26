package com.naveen.problems.problem1971;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-if-path-exists-in-graph/
public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1) return true;

        boolean[] visited = new boolean[n];
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            addEdge(g, e);
        }

        return dfs(g, source, destination, visited);
    }

    private boolean dfs(List<List<Integer>> g, int index, int destination, boolean[] visited) {
        visited[index] = true;

        for (int adj : g.get(index)) {
            if (adj == destination) return true;

            if (!visited[adj] && dfs(g, adj, destination, visited)) {
                return true;
            }
        }

        return false;
    }

    private void addEdge(List<List<Integer>> g, int[] e) {
        g.get(e[0]).add(e[1]);
        g.get(e[1]).add(e[0]);
    }
}
