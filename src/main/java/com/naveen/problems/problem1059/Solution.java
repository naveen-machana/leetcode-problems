package com.naveen.problems.problem1059;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.ca/all/1059.html
// All Paths from Source Lead to Destination
// Given the edges of a directed graph, and two nodes source and destination of this graph,
// determine whether or not all paths starting from source eventually end at destination, that is:
// At least one path exists from the source node to the destination node
// If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
// The number of possible paths from source to destination is a finite number.
// Return true if and only if all roads from source lead to destination.
public class Solution {
    boolean isReachable(int[][] edges, int s, int d, int n) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) g.get(e[0]).add(e[1]);

        return dfs(g, new boolean[n], s, d);
    }

    // Note the modified dfs below
    boolean dfs(List<List<Integer>> g, boolean[] visited, int s, int d) {
        if (g.get(s).size() == 0) return s == d;
        if (visited[s]) return false;
        visited[s] = true;
        for (int adj : g.get(s))
            if (!dfs(g, visited, adj, d))
                return false;

        visited[s] = false;
        return true;

    }
}
