package com.naveen.problems.problem399;

import java.util.*;

// https://leetcode.com/problems/evaluate-division/description/
// simple dfs traversal
// a/c = a/b * b/c = v[0] * v[1]
public class Solution {
    public double[] calcEquation(List<List<String>> e, double[] v, List<List<String>> qrs) {
        Map<String, Map<String, Double>> g = buildGraph(e, v);

        double[] res = new double[qrs.size()];
        for (int i = 0; i < qrs.size(); i++) {
            res[i] = calculate(g, qrs.get(i).get(0), qrs.get(i).get(1), new HashSet<>());
        }
        return res;
    }

    private double calculate(Map<String, Map<String, Double>> g, String src, String dst, Set<String> visited) {

        if (!g.containsKey(src)) return -1;

        if (g.get(src).containsKey(dst)) return g.get(src).get(dst);

        visited.add(src);
        for (String adj : g.get(src).keySet()) {
            if (!visited.contains(adj)) {
                double subres = calculate(g, adj, dst, visited);
                if (subres != -1) return subres * g.get(src).get(adj);
            }
        }
        return -1;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> e, double[] v) {
        Map<String, Map<String, Double>> g = new HashMap<>();
        for (int i = 0; i < e.size(); i++) {
            String src = e.get(i).get(0);
            String dst = e.get(i).get(1);
            g.putIfAbsent(src, new HashMap<>());
            g.putIfAbsent(dst, new HashMap<>());
            g.get(src).put(dst, v[i]);
            g.get(dst).put(src, 1 / v[i]);
        }
        return g;
    }
}
