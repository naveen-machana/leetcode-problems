package com.naveen.problems.graphs;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/all-paths-from-source-to-target/
// Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
// find all possible paths from node 0 to node n - 1 and return them in any order.
//
//The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
// (i.e., there is a directed edge from node i to node graph[i][j]).
public class Problem979_AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] g) {
        int src = 0, dst = g.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        dfs(g, res, src, dst, new boolean[g.length], new ArrayList<>());
        return res;
    }

    private void dfs(int[][] g, List<List<Integer>> res, int src, int dst, boolean[] visited, List<Integer> cur) {
        visited[src] = true;
        cur.add(src);
        if (src == dst) {
            res.add(new ArrayList<>(cur));
            visited[src] = false;
            cur.remove(cur.size() - 1);
            return;
        }

        for (int i = 0; i < g[src].length; i++) {
            if (!visited[g[src][i]]) {
                dfs(g, res, g[src][i], dst, visited, cur);
            }
        }

        visited[src] = false;
        cur.remove(cur.size() - 1);
    }
}
