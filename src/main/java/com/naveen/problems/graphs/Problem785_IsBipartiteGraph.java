package com.naveen.problems.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/is-graph-bipartite/
// There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
// You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
// More formally, for each v in graph[u], there is an undirected edge between node u and node v.
// The graph has the following properties:
//
//There are no self-edges (graph[u] does not contain u).
//There are no parallel edges (graph[u] does not contain duplicate values).
//If v is in graph[u], then u is in graph[v] (the graph is undirected).
//The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
//A graph is bipartite if the nodes can be partitioned into two independent sets A and B
// such that every edge in the graph connects a node in set A and a node in set B.
//
//Return true if and only if it is bipartite.
class Problem785_IsBipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++)
            if (colors[i] == -1)
                if (!isBipartiteComponent(graph, colors, i))
                    return false;

        return true;
    }

    private boolean isBipartiteComponent(int[][] g, int[] colors, int v) {
        colors[v] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{v, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int adj : g[cur[0]]) {
               if (colors[adj] == -1) {
                   colors[adj] = cur[1] ^ 1;
                   q.offer(new int[]{adj, colors[adj]});
               }
               else if (colors[adj] == colors[cur[0]])
                   return false;
            }
        }
        return true;
    }
}
