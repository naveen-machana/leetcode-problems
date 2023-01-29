package com.naveen.problems.problem802;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-eventual-safe-states/
// 802. Find Eventual Safe States
// There is a directed graph of n nodes with each node labeled from 0 to n - 1. Th
// e graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent
// to node i, meaning there is an edge from node i to each node in graph[i].
//
//A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting
// from that node leads to a terminal node (or another safe node).
//
//Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
public class Solution {
    public List<Integer> eventualSafeNodes(int[][] g) {
        boolean[] visited = new boolean[g.length];
        boolean[] pathvis = new boolean[g.length];
        boolean[] check = new boolean[g.length];

        for (int i = 0; i < g.length; i++) {
            if (!visited[i]){
                cycleDfs(g, visited, pathvis, i);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < pathvis.length; i++)
            if (!pathvis[i])
                res.add(i);

        return res;
    }

    boolean cycleDfs(int[][] g, boolean[] visited, boolean[] pathvis, int v) {

        pathvis[v] = true;
        visited[v] = true;

        for (int next : g[v]) {
            if (!visited[next]) {
                if (cycleDfs(g, visited, pathvis, next))
                    return true;
            }
            else if (pathvis[next])
                return true;
        }

        pathvis[v] = false;
        return false;
    }
}
