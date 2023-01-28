package com.naveen.problems;

import java.util.*;

// Dijkstra's shortest path algorithm
// https://leetcode.com/problems/network-delay-time/
// You are given a network of n nodes, labeled from 1 to n. You are also given times,
// a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node,
// and wi is the time it takes for a signal to travel from source to target.
//
//We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
// If it is impossible for all the n nodes to receive the signal, return -1.
public class problem743 {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(times, 4, 2));
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        for (int[] e : times)
            g.computeIfAbsent(e[0], key -> new HashMap<>()).put(e[1], e[2]);

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));

        int max = -1;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curw = cur.w, curv = cur.v;
            if (visited[curv]) continue;
            visited[curv] = true;
            max = curw;
            n--;
            if (g.containsKey(curv)) {
                for (int next : g.get(curv).keySet())
                    pq.offer(new Node(next, curw + g.get(curv).get(next)));
            }
        }

        return 0 == n ? max : -1;
    }

    private static class Node implements Comparable<Node> {
        int v, w;
        public Node(int v, int w) {
            this.v = v; this.w = w;
        }
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
}
