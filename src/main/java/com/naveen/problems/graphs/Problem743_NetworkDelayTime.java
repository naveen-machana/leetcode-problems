package com.naveen.problems.graphs;

import java.util.*;

// Dijkstra's shortest path algorithm
// https://leetcode.com/problems/network-delay-time/
// You are given a network of n nodes, labeled from 1 to n. You are also given times,
// a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node,
// and wi is the time it takes for a signal to travel from source to target.
//
//We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
// If it is impossible for all the n nodes to receive the signal, return -1.
public class Problem743_NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(times, 4, 2));
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int[] e : times) g.get(e[0]).add(List.of(e[1], e[2]));

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((one, two) -> one.get(1) - two.get(1));
        pq.offer(List.of(k, 0));
        Set<Integer> visited = new HashSet<>();

        int cost = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            if (visited.contains(cur.get(0))) continue;
            cost = cur.get(1);
            visited.add(cur.get(0));
            for (List<Integer> adj : g.get(cur.get(0))) pq.offer(List.of(adj.get(0), adj.get(1) + cur.get(1)));
        }

        return n == visited.size() ? cost : -1;
    }
}
