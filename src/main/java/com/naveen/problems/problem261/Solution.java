package com.naveen.problems.problem261;

import java.util.ArrayList;
import java.util.List;

// https://www.lintcode.com/problem/178/
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++)
            g.add(new ArrayList<>());

        for (int[] e : edges)
            addEdge(g, e);

        for (int i = 0; i < n; i++) {
            if (!visited[i] && cycle(g, i, -1, visited))
                return true;
        }
        return false;
    }

    private boolean cycle(List<List<Integer>> g, int v, int parent, boolean[] visited) {
        visited[v] = true;

        for (int adj : g.get(v)) {
            if (!visited[adj] && cycle(g, adj, v, visited))
                return true;

            else if (parent != adj)
                return true;
        }

        return false;
    }

    private void addEdge(List<List<Integer>> g, int[] e) {
        g.get(e[0]).add(e[1]);
        g.get(e[1]).add(e[0]);
    }
}
