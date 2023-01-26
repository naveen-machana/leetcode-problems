package com.naveen.problems.problem261;

import java.util.ArrayList;
import java.util.List;

// https://www.lintcode.com/problem/178/
// 1. should be connected means, we should be able to reach every node from a given node
// 2. there should be no cycle
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++)
            g.add(new ArrayList<>());

        for (int[] e : edges)
            addEdge(g, e);

        if (cycle(g, 0, -1, visited)) return false;
        for (int i = 0; i < visited.length; i++)
            if(!visited[i]) return false;
        return true;
    }

    private boolean cycle(List<List<Integer>> g, int v, int parent, boolean[] visited) {
        visited[v] = true;

        for (int adj : g.get(v)) {
            if (!visited[adj]) {
                if (cycle(g, adj, v, visited))
                    return true;
            }
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
