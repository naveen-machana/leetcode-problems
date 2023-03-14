package com.naveen.problems.graphs;

import java.util.*;

// 1129. Shortest Path with Alternating Colors
// https://leetcode.com/problems/shortest-path-with-alternating-colors/solutions/3049265/shortest-path-with-alternating-colors/?orderBy=most_votes
// You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1.
// Each edge is red or blue in this graph, and there could be self-edges and parallel edges.
//
// You are given two arrays redEdges and blueEdges where:
//
// redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
// blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
// Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x
// such that the edge colors alternate along the path, or -1 if such a path does not exist.
public class Problem1129_ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<List<Integer>>> g = new HashMap<>();
        for (int[] e : redEdges) g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(Arrays.asList(e[1], 0));
        for (int[] e : blueEdges) g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(Arrays.asList(e[1], 1));

        boolean[][] visited = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();
        // 0 - vertex, 0 - steps, 0 - color
        q.offer(new int[]{0, 0, -1});
        int[] res = new int[n];
        Arrays.fill(res, -1);
        res[0] = 0;
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pv = cur[0], ps = cur[1], pc = cur[2];
            List<List<Integer>> neighbours = g.getOrDefault(pv, Collections.EMPTY_LIST);
            for (List<Integer> adj : neighbours) {
                int nv = adj.get(0), nc = adj.get(1);
                if (!visited[nv][nc] && nc != pc) {
                    if (res[nv] == -1) res[nv] = ps + 1;
                    visited[nv][nc] = true;
                    q.offer(new int[]{nv, ps + 1, nc});
                }
            }
        }
        return res;
    }
}
