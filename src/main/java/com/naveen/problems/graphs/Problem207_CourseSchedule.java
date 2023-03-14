package com.naveen.problems.graphs;

import java.util.*;

// https://leetcode.com/problems/course-schedule/
// topological sorting
public class Problem207_CourseSchedule {
    public boolean canFinish(int n, int[][] order) {
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        int[] inedges = new int[n];
        for (int[] e : order) {
            g.get(e[1]).add(e[0]);
            inedges[e[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inedges.length; i++)
            if (inedges[i] == 0) q.add(i);

        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int v = q.poll();
            for (int adj : g.get(v))
                if (--inedges[adj] == 0)
                    q.offer(adj);

        }
        return count == n;
    }
}
