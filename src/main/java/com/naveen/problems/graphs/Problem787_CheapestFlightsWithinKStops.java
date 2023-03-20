package com.naveen.problems.graphs;

import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
// There are n cities connected by some number of flights. You are given an array flights
// where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
//
//You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
// If there is no such route, return -1.
public class Problem787_CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int[][] f = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(findCheapestPrice(3, f, 0, 2, 1));
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        for (int[] f : flights)
            g.computeIfAbsent(f[0], key -> new HashMap<>()).put(f[1], f[2]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, k + 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int price = cur[0];
            int curv = cur[1];
            int steps = cur[2];
            if (curv == dst) return price;
            if (steps <= 0) continue;
            Map<Integer, Integer> adj = g.getOrDefault(curv, Collections.EMPTY_MAP);
            for (int next : adj.keySet()) {
                pq.offer(new int[]{price + adj.get(next), next, steps - 1});
            }
        }
        return -1;
    }
}
