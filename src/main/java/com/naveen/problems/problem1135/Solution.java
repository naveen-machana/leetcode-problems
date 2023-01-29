package com.naveen.problems.problem1135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.ca/all/1135.html
// 1135. Connecting Cities With Minimum Cost
// There are N cities numbered from 1 to N.
//
// You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect
// city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the
// same as connecting city2 and city1.)
//
// Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1)
// that connects those two cities together.  The cost is the sum of the connection costs used.
// If the task is impossible, return -1.
public class Solution {
    int minCost(int n, int E, int[][] edges) {
        List<List<List<Integer>>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(List.of(e[1], e[2]));
            g.get(e[1]).add(List.of(e[0], e[2]));
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0});
        boolean[] visited = new boolean[n + 1];

        int res = 0, count = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curp = cur[1], curv = cur[0];
            if (visited[curv]) continue;

            res += curp;
            visited[curv] = true;

            for (List<Integer> adj : g.get(curv)) {
                int adjv = adj.get(0), adjp = adj.get(1);
                if (!visited[adjv])
                    pq.offer(new int[]{adjv, adjp});
            }
        }

        return count == n ? res : -1;
    }

}
