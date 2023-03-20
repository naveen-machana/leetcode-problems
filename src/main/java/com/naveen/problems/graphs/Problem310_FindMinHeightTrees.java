package com.naveen.problems.graphs;

import java.util.*;

class Problem310_FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }

        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        int[] degree = new int[n];
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < degree.length; i++)
            if (degree[i] == 1)
                q.offer(i);

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            res = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) {
                int cur = q.poll();
                res.add(cur);

                for (int adj : g.get(cur)) {
                    if (--degree[adj] == 1)
                        q.offer(adj);
                }
            }

        }

        return res;
    }
}