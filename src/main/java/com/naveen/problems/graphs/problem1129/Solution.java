package com.naveen.problems.graphs.problem1129;

import java.util.*;

// 1129. Shortest Path with Alternating Colors
// https://leetcode.com/problems/shortest-path-with-alternating-colors/solutions/3049265/shortest-path-with-alternating-colors/?orderBy=most_votes
// You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1.
// Each edge is red or blue in this graph, and there could be self-edges and parallel edges.
//
//You are given two arrays redEdges and blueEdges where:
//
//redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
//blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
//Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x
// such that the edge colors alternate along the path, or -1 if such a path does not exist.
public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<List<Integer>>> g = new HashMap<>();
        for (int[] re : redEdges)
            g.computeIfAbsent(re[0], k -> new ArrayList<>()).add(Arrays.asList(re[1], 0));

        for (int[] be : blueEdges)
            g.computeIfAbsent(be[0], k -> new ArrayList<>()).add(Arrays.asList(be[1], 1));

        int[] res = new int[n];
        Arrays.fill(res, -1);
        Queue<int[]> q = new LinkedList<>();
        // triplet {i - node, j - steps, k - color}
        q.offer(new int[]{0, 0, -1});
        res[0] = 0;
        // row - node, column - color
        boolean[][] visited = new boolean[n][2];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] parent = q.poll();
            int pv = parent[0], ps = parent[1], pc = parent[2];

            List<List<Integer>> neighbors = g.getOrDefault(pv, Collections.EMPTY_LIST);

            for (List<Integer> adj : neighbors) {
                int av = adj.get(0), ac = adj.get(1);
                if (!visited[av][ac] && ac != pc) {
                    if (res[av] == -1) res[av] = ps + 1;
                    visited[av][ac] = true;
                    q.offer(new int[]{av, ps + 1, ac});
                }
            }
        }
        return res;
    }
}
