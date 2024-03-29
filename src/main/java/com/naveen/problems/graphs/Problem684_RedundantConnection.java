package com.naveen.problems.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/redundant-connection/description/
// In this problem, a tree is an undirected graph that is connected and has no cycles.
//
//You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
// The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
// The graph is represented as an array edges of length n where edges[i] = [ai, bi]
// indicates that there is an edge between nodes ai and bi in the graph.
//
//Return an edge that can be removed so that the resulting graph is a tree of n nodes.
// If there are multiple answers, return the answer that occurs last in the input.
public class Problem684_RedundantConnection {

    public int[] findRedundantConnection2(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int[] e : edges) {
            if (dfs(g, e[0], e[1], new HashSet<>()))
                return e;
            else {
                g.get(e[0]).add(e[1]);
                g.get(e[1]).add(e[0]);
            }
        }

        return new int[]{-1, -1};
    }

    private boolean dfs(List<List<Integer>> g, int s, int d, Set<Integer> seen) {
        if (s == d) return true;
        seen.add(s);
        for (int adj : g.get(s))
            if (!seen.contains(adj) && dfs(g, adj, d, seen))
                return true;
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] rep = new int[n];
        for (int i = 0; i < n; i++) rep[i] = i;
        for (int[] e : edges) if (!union(e[0] - 1, e[1] - 1, rep)) return e;
        return new int[]{-1, -1};
    }

    private int find(int a, int[] rep) {
        if (a == rep[a]) return a;
        rep[a] = find(rep[a], rep);
        return rep[a];
    }

    private boolean union(int a, int b, int[] rep) {
        int ra = find(a, rep);
        int rb = find(b, rep);
        if (ra == rb) return false;
        rep[ra] = rb;
        return true;
    }
}
