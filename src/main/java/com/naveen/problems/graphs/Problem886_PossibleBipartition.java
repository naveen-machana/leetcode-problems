package com.naveen.problems.graphs;

import java.util.*;

// https://leetcode.com/problems/possible-bipartition/
// 886. Possible Bipartition
// We want to split a group of n people (labeled from 1 to n) into two groups of any size.
// Each person may dislike some other people, and they should not go into the same group.
//
//Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai
// does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
public class Problem886_PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int[] e : dislikes) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);

        for (int i = 1; i <= n; i++)
            if (colors[i] == -1 && !isBipartite(g, colors, i))
                return false;

        return true;
    }

    boolean isBipartite(List<List<Integer>> g, int[] colors, int v) {
        colors[v] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int adj : g.get(cur)) {
                if (colors[adj] == -1) {
                    colors[adj] = colors[cur] ^ 1;
                    q.offer(adj);
                } else if (colors[adj] == colors[cur])
                    return false;
            }
        }

        return true;
    }
}
