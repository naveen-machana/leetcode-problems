package com.naveen.problems.graphs;

import java.util.*;

// https://leetcode.com/problems/course-schedule/
// topological sorting
public class Problem207_CourseSchedule {
    public boolean canFinish(int n, int[][] order) {
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        int[] degree = new int[n];

        for (int[] cur : order) {
            degree[cur[0]]++;
            g.get(cur[1]).add(cur[0]);
        }

        int[] topo = new int[n]; int topoindex = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (degree[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int cur = q.poll();
            topo[topoindex++] = cur;

            for (int adj : g.get(cur))
                if (--degree[adj] == 0)
                    q.offer(adj);
        }

        return topoindex == n;
    }
}
