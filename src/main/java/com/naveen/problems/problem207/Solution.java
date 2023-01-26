package com.naveen.problems.problem207;

import java.util.*;

// https://leetcode.com/problems/course-schedule/
// topological sorting
public class Solution {
    public boolean canFinish(int n, int[][] order) {
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] e : order) {
            addEdge(g, e);
        }

        int[] degree = new int[n];

        for (int[] cur : order) {
            degree[cur[0]]++;
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                q.offer(i);
                count++;
            }
        }

        boolean[] visited = new boolean[n];

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int adj : g.get(cur)) {
                if (!visited[adj]) {
                    degree[adj]--;
                    if (degree[adj] == 0) {
                        q.offer(adj);
                        count++;
                    }
                }
            }
        }

        return count == n;
    }

    private void addEdge(List<List<Integer>> g, int[] e) {
        g.get(e[0]).add(e[1]);
        g.get(e[1]).add(e[0]);
    }
}
