package com.naveen.problems.graphs;

import java.util.ArrayList;
import java.util.List;

// https://www.lintcode.com/problem/178/
// 1. should be connected means, we should be able to reach every node from a given node
// 2. there should be no cycle
public class Problem261_GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        if (cycle(g, visited, 0, -1)) return false;

        for (int i = 0; i < visited.length; i++)
            if (!visited[i]) return false;

        return true;
    }

    private boolean cycle(List<List<Integer>> g, boolean[] visited, int v, int p) {
        visited[v] = true;

        for (int adj : g.get(v)) {
            if (!visited[adj] && cycle(g, visited, adj, v)) return true;
            else if (adj != p) return true;
        }

        return false;
    }
}
