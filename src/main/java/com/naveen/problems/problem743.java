package com.naveen.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

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
        List<List<List>> g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int[] e : times) {
            List<Integer> edW = List.of(e[1], e[2]);
            g.get(e[0]).add(edW);
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));
        boolean[] visited = new boolean[n + 1];

        int maxTimeToReachAllNodes = -1;
        int count = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.v]) continue;
            visited[cur.v] = true;
            maxTimeToReachAllNodes = Math.max(maxTimeToReachAllNodes, cur.w);
            count++;
            for (List<Integer> adj : g.get(cur.v)) {
                int v = adj.get(0), w = adj.get(1);
                if (!visited[v]) {
                    distance[v] = Math.min(distance[v], distance[cur.v] + w);
                    pq.offer(new Node(v, distance[v]));
                }
            }
        }

        return count == n ? maxTimeToReachAllNodes : -1;
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
